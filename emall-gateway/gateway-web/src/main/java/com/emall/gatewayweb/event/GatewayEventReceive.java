package com.emall.gatewayweb.event;

import com.emall.gatewayweb.service.IRouteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.stereotype.Component;


/**
 * rabbitmq  接受消息
 */
@Component
@Slf4j
@RabbitListener(queues = "gateway-queue")
public class GatewayEventReceive {

    @Autowired
    private IRouteService routeService;

    public void handleMessage(RouteDefinition routeDefinition){
        log.info("rabbitmq中的路由信息：{}", routeDefinition);
        // TODO 实现动态del路由
        routeService.save(routeDefinition);
    }

}
