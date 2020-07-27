package com.emall.gatewayadmin.rabbit.event;

import com.emall.gatewayadmin.config.BusConfig;
import com.emall.gatewayadmin.rabbit.confirm.ExchangeMessageConfirm;
import com.emall.gatewayadmin.rabbit.confirm.QueueMessageReturn;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


/**
 * rabbitmq  网关路由发送消息到rabbitmq
 */
@Component
@Slf4j
public class GatewayEventSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private MessageConverter messageConverter;

    @Autowired
    private ExchangeMessageConfirm exchangeMessageConfirm;

    @Autowired
    private QueueMessageReturn queueMessageReturn;

    /**
     * spring生命周期回调
     */
    @PostConstruct
    public void init() {
        rabbitTemplate.setMessageConverter(messageConverter);
        rabbitTemplate.setReturnCallback(queueMessageReturn);
        rabbitTemplate.setConfirmCallback(exchangeMessageConfirm);
    }

    public void send(String routingKey, Object object) {
        log.info("routingKey:{}=>message:{}", routingKey, object);
        rabbitTemplate.convertAndSend(BusConfig.GATEWAY_EXCHANGE_NAME, routingKey, object);
    }

}
