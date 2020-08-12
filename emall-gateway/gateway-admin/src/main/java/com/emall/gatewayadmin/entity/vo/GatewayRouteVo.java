package com.emall.gatewayadmin.entity.vo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.emall.gatewayadmin.entity.po.FilterDefinition;
import com.emall.gatewayadmin.entity.po.GatewayRoutePo;
import com.emall.gatewayadmin.entity.po.PredicateDefinition;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@Data
@Slf4j
public class GatewayRouteVo implements Serializable {

    private String id;
    private String uri;
    private Integer order;
    private List<FilterDefinition> filters = new ArrayList<>();
    private List<PredicateDefinition> predicates = new ArrayList<>();

    public GatewayRouteVo(GatewayRoutePo gatewayRoutePo) {
        this.id = String.valueOf(gatewayRoutePo.getId());
        this.uri = gatewayRoutePo.getUri();
        this.order = gatewayRoutePo.getOrders();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            this.filters = objectMapper.readValue(gatewayRoutePo.getFilters(), new TypeReference<List<FilterDefinition>>() {
            });
            this.predicates = objectMapper.readValue(gatewayRoutePo.getPredicates(), new TypeReference<List<PredicateDefinition>>() {
            });
        } catch (IOException e) {
            log.error("网关路由对象转换失败", e);
        }
    }

}
