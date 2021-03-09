package com.emall.emallumsservice.rabbit.event;


import com.emall.emallumsservice.config.BusConfig;
import com.emall.emallumsservice.rabbit.confirm.ExchangeMessageConfirm;
import com.emall.emallumsservice.rabbit.confirm.QueueMessageReturn;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 授权资源事件
 */
@Component
@Slf4j
public class ResourceEventSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private MessageConverter messageConverter;

    @Autowired
    private ExchangeMessageConfirm exchangeMessageConfirm;

    @Autowired
    private QueueMessageReturn queueMessageReturn;

    @PostConstruct
    public void init() {
        rabbitTemplate.setMessageConverter(messageConverter);
        rabbitTemplate.setConfirmCallback(exchangeMessageConfirm);
        rabbitTemplate.setReturnCallback(queueMessageReturn);
    }

    public void send(String key, Object object) {
        log.debug("key：{}", key);
        log.debug("message：{}", object);
        rabbitTemplate.convertAndSend(BusConfig.RESOURCE_EXCHANGE_NAME, key, object);
    }

}
