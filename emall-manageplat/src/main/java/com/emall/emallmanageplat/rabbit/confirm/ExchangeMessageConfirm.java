package com.emall.emallmanageplat.rabbit.confirm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class ExchangeMessageConfirm implements ConfirmCallback {

    /**
     * 确认应答
     *
     * @param correlationData 消息体
     * @param ack             应答成功与否
     * @param messCause       异常消息
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String messCause) {
        if (ack) {
            System.out.println("交换机确认收到消息");
        } else {
            log.info("交换机没有收到消息，原因是： {}", messCause);
        }
    }
}
