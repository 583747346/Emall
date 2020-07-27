package com.emall.gatewayadmin.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.ContentTypeDelegatingMessageConverter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 网关路由消息总线相关配置
 * 交换机--绑定(路由)--队列
 * 消息转换器
 */
@Configuration
@Slf4j
public class BusConfig {

    public static final String GATEWAY_EXCHANGE_NAME = "gateway-exchange";
    public static final String GATEWAY_QUEUE_NAME = "gateway-queue";
    public static final String GATEWAY_BINDING_NAME = "gateway-binding";

    /**
     * rabbitmq 队列
     *
     * @return
     */
    @Bean
    Queue queue() {
        log.info("使用的队列是：{}", GATEWAY_QUEUE_NAME);
        return new Queue(GATEWAY_QUEUE_NAME, false);
    }

    /**
     * rabbitmq 交换机，接收客户端信息
     * 可以起到隔离得作用
     * 一个交换机可以绑定多个队列
     * 当交换机接收到消息的时候，会广播所有队列消费消息
     * 交换机的种类：TopicExchange(智能交换机)，DirectExchange（直连交换机），FanoutExchange（广播交换机），CustomExchange（自定义交换机）
     */
    @Bean
    TopicExchange topicExchange() {
        log.info("使用的交换机为：{}", GATEWAY_EXCHANGE_NAME);
        return new TopicExchange(GATEWAY_EXCHANGE_NAME);
    }

    /**
     * rabbitmq 绑定（主要是用于"交换机"《—绑定—》队列）
     */
    @Bean
    Binding binding(Queue queue, TopicExchange topicExchange) {
        log.info("交换机 -{}", topicExchange, " 绑定 -{}", queue);
        return BindingBuilder.bind(queue).to(topicExchange).with(GATEWAY_BINDING_NAME);
    }


    /**
     * 消息转换器
     * @return
     */
    @Bean
    public MessageConverter messageConverter() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        return new ContentTypeDelegatingMessageConverter(new Jackson2JsonMessageConverter(objectMapper));
    }


}
