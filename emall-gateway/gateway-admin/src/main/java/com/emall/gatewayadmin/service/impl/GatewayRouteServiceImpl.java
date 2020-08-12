package com.emall.gatewayadmin.service.impl;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.gatewayadmin.config.BusConfig;
import com.emall.gatewayadmin.dao.GatewayRouteMapper;
import com.emall.gatewayadmin.entity.po.GatewayRoutePo;
import com.emall.gatewayadmin.entity.vo.GatewayRouteVo;
import com.emall.gatewayadmin.entity.params.GatewayRouteQueryParam;
import com.emall.gatewayadmin.rabbit.event.GatewayEventSender;
import com.emall.gatewayadmin.service.GatewayRouteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URI;
import java.util.List;

@Service
@Slf4j
public class GatewayRouteServiceImpl extends ServiceImpl<GatewayRouteMapper, GatewayRoutePo> implements GatewayRouteService {

    private static final String GATEWAY_ROUTE = "gateway-routes::";


    @Autowired
    private GatewayEventSender gatewayEventSender;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    @Transactional
    public boolean add(GatewayRoutePo gatewayRoutePo) {
        boolean success = this.save(gatewayRoutePo);
        //路由信息缓存到redis
        stringRedisTemplate.opsForValue().set(GATEWAY_ROUTE + gatewayRoutePo.getRouteId(), toJson(new GatewayRouteVo(gatewayRoutePo)));
        //路由信息发送到rabbitmq的gateway-queue队列中
        RouteDefinition routeDefinition = gatewayRoutePoToRouteDefinition(gatewayRoutePo);
        gatewayEventSender.send(BusConfig.GATEWAY_BINDING_NAME, routeDefinition);
        return success;
    }

    /**
     * 删除路由信息
     *
     * @param id
     * @return
     */
    @Override
    public boolean delete(Long id) {
        boolean success = this.removeById(id);
        GatewayRoutePo gatewayRoutePo = this.getById(id);
        //redis中删除路由信息
        stringRedisTemplate.delete(GATEWAY_ROUTE + gatewayRoutePo.getRouteId());
        //消息队列中发送需要删除的队列信息
        RouteDefinition routeDefinition = gatewayRoutePoToRouteDefinition(gatewayRoutePo);
        gatewayEventSender.send(BusConfig.GATEWAY_BINDING_NAME, routeDefinition);
        return success;
    }

    /**
     * 更新路由信息
     *
     * @param gatewayRoutePo
     * @return
     */
    @Override
    public boolean update(GatewayRoutePo gatewayRoutePo) {
        boolean success = this.updateById(gatewayRoutePo);
        //redis中删除对应的路由，然后插入
        stringRedisTemplate.delete(GATEWAY_ROUTE + gatewayRoutePo.getRouteId());
        stringRedisTemplate.opsForValue().set(GATEWAY_ROUTE + gatewayRoutePo.getRouteId(), toJson(new GatewayRouteVo(get(gatewayRoutePo.getId()))));
        //发送修改路由信息到消息队列
        RouteDefinition routeDefinition = gatewayRoutePoToRouteDefinition(gatewayRoutePo);
        gatewayEventSender.send(BusConfig.GATEWAY_BINDING_NAME, routeDefinition);
        return success;
    }

    @Override
    public GatewayRoutePo get(Long id) {
        return this.baseMapper.selectById(id);
    }

    @Override
    public List<GatewayRoutePo> query(GatewayRouteQueryParam gatewayRouteQueryParam) {
        QueryWrapper<GatewayRoutePo> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge(null != gatewayRouteQueryParam.getCreatedTimeStart(), "created_time", gatewayRouteQueryParam.getCreatedTimeStart());
        queryWrapper.le(null != gatewayRouteQueryParam.getCreatedTimeEnd(), "created_time", gatewayRouteQueryParam.getCreatedTimeEnd());
        queryWrapper.eq(StringUtils.isNotBlank(gatewayRouteQueryParam.getUri()), "uri", gatewayRouteQueryParam.getUri());
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @PostConstruct  //spring容器初始化完回调加载路由信息到redis
    public boolean overload() {
        List<GatewayRoutePo> gatewayRoutes = this.baseMapper.selectList(new QueryWrapper<>());
        ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
        gatewayRoutes.forEach(gatewayRoutePo -> {
            gatewayRoutePo.setRouteId(gatewayRoutePo.getRouteId());
            opsForValue.set(GATEWAY_ROUTE + gatewayRoutePo.getRouteId(), toJson(new GatewayRouteVo(gatewayRoutePo)));
        });
        return true;
    }

    /**
     * GatewayRoute转换为json
     *
     * @param gatewayRouteVo redis需要的vo
     * @return json string
     */
    private String toJson(GatewayRouteVo gatewayRouteVo) {
        String routeDefinitionJson = Strings.EMPTY;
        try {
            routeDefinitionJson = new ObjectMapper().writeValueAsString(gatewayRouteVo);
        } catch (JsonProcessingException e) {
            log.error("网关对象序列化为json String", e);
        }
        return routeDefinitionJson;
    }


    /**
     * 将路由信息转换为gateway所需要的object
     *
     * @param gatewayRoutePo
     * @return
     */
    private RouteDefinition gatewayRoutePoToRouteDefinition(GatewayRoutePo gatewayRoutePo) {
        RouteDefinition routeDefinition = new RouteDefinition();
        routeDefinition.setId(gatewayRoutePo.getRouteId());          //路由id
        routeDefinition.setOrder(gatewayRoutePo.getOrders());        //路由排序
        routeDefinition.setUri(URI.create(gatewayRoutePo.getUri())); //路由url
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            //添加过滤条件，例如StripPrefix=1 =》 去掉第一个"/"的path
            routeDefinition.setFilters(objectMapper.readValue(gatewayRoutePo.getFilters(), new TypeReference<List<FilterDefinition>>() {
            }));
            //添加谓词
            routeDefinition.setPredicates(objectMapper.readValue(gatewayRoutePo.getPredicates(), new TypeReference<List<PredicateDefinition>>() {
            }));
        } catch (IOException e) {
            log.error("网关路由对象转换失败", e);
        }
        return routeDefinition;
    }
}
