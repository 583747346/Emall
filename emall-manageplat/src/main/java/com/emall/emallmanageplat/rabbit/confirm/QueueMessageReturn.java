package com.emall.emallmanageplat.rabbit.confirm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ReturnCallback;
import org.springframework.stereotype.Component;

/**
 * 队列收到消息确认
 */
@Component
@Slf4j
public class QueueMessageReturn implements ReturnCallback {

    /**
     * @param message    消息
     * @param replyCode
     * @param replyText
     * @param exchange
     * @param routingKey
     */
    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        //TODO 队列接受消息确认
    }
}
