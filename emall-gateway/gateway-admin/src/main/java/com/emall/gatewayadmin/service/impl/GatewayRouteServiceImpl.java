package com.emall.gatewayadmin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.emall.gatewayadmin.dao.GatewayRouteMapper;
import com.emall.gatewayadmin.entity.po.GatewayRoutePo;
import com.emall.gatewayadmin.entity.vo.GatewayRouteVo;
import com.emall.gatewayadmin.entity.params.GatewayRouteQueryParam;
import com.emall.gatewayadmin.service.GatewayRouteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class GatewayRouteServiceImpl extends ServiceImpl<GatewayRouteMapper, GatewayRoutePo> implements GatewayRouteService {

    private static final String GATEWAY_ROUTES = "gateway_routes::";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public long add(GatewayRoutePo gatewayRouteEntity) {
        long gatewayId = this.baseMapper.insert(gatewayRouteEntity);
        stringRedisTemplate.opsForValue().set(GATEWAY_ROUTES + gatewayRouteEntity.getId(), toJson(new GatewayRouteVo(gatewayRouteEntity)));
        return gatewayId;
    }

    @Override
    public boolean delete(String id) {
        boolean flag = this.delete(id);
        stringRedisTemplate.delete(GATEWAY_ROUTES + id);
        return flag;
    }

    @Override
    public boolean update(GatewayRoutePo gatewayRouteEntity) {
        boolean flag = this.updateById(gatewayRouteEntity);
        stringRedisTemplate.delete(GATEWAY_ROUTES + gatewayRouteEntity.getId());
        stringRedisTemplate.opsForValue().set(GATEWAY_ROUTES, toJson(new GatewayRouteVo(get(String.valueOf(gatewayRouteEntity.getId())))));
        return flag;
    }

    @Override
    public GatewayRoutePo get(String id) {
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
    public boolean overload() {
        List<GatewayRoutePo> gatewayRoutes = this.baseMapper.selectList(new QueryWrapper<>());
        ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
        gatewayRoutes.forEach(gatewayRoute ->
                opsForValue.set(GATEWAY_ROUTES + gatewayRoute.getId(), toJson(new GatewayRouteVo(gatewayRoute)))
        );
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
}
