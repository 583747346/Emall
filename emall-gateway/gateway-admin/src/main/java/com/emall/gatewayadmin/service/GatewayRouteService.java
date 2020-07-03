package com.emall.gatewayadmin.service;



import com.emall.gatewayadmin.entity.po.GatewayRoutePo;
import com.emall.gatewayadmin.entity.params.GatewayRouteQueryParam;

import java.util.List;

public interface GatewayRouteService {
    /**
     * 获取网关路由
     *
     * @param id
     * @return
     */
    GatewayRoutePo get(String id);

    /**
     * 新增网关路由
     *
     * @param gatewayRoute
     * @return
     */
    long add(GatewayRoutePo gatewayRoute);

    /**
     * 查询网关路由
     *
     * @return
     */
    List<GatewayRoutePo> query(GatewayRouteQueryParam gatewayRouteQueryParam);

    /**
     * 更新网关路由信息
     *
     * @param gatewayRoute
     */
    boolean update(GatewayRoutePo gatewayRoute);

    /**
     * 根据id删除网关路由
     *
     * @param id
     */
    boolean delete(String id);

    /**
     * 重新加载网关路由配置到redis
     * @return 成功返回true
     */
    boolean overload();
}
