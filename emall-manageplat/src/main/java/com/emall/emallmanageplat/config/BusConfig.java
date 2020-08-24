package com.emall.emallmanageplat.config;

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


@Configuration
@Slf4j
public class BusConfig {

    /******************************新添资源信息*******************************************/
    public static final String RESOURCE_EXCHANGE_NAME = "resource-exchange";
    public static final String RESOURCE_QUEUE_NAME = "resource-queue";
    public static final String RESOURCE_BINDING_NAME = "resource-binding";

    /**
     * rabbitmq 队列
     *
     * @return
     */
    @Bean
    Queue queue() {
        log.info("使用的队列是：{}", RESOURCE_QUEUE_NAME);
        return new Queue(RESOURCE_QUEUE_NAME, false);
    }

    /**
     * rabbitmq 交换机，接收客户端信息
     * 可以起到隔离得作用
     * 一个交换机可以绑定多个队列
     * 当交换机接收到消息的时候，会广播所有队列消费
     * 交换机的种类：TopicExchange(智能交换机)，DirectExchange（直连交换机），FanoutExchange（广播交换机），CustomExchange（自定义交换机）
     */
    @Bean
    TopicExchange topicExchange() {
        log.info("使用的交换机为：{}", RESOURCE_EXCHANGE_NAME);
        return new TopicExchange(RESOURCE_EXCHANGE_NAME);
    }

    /**
     * rabbitmq 绑定（主要是用于"交换机"《—绑定—》队列）
     */
    @Bean
    Binding binding(Queue queue, TopicExchange topicExchange) {
        log.info("交换机：{}, 绑定队列： {}", topicExchange , queue);
        return BindingBuilder.bind(queue).to(topicExchange).with(RESOURCE_BINDING_NAME);
    }

    /**
     * rabbitmq 消息体序列化
     */
    @Bean
    MessageConverter messageConverter() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        return new ContentTypeDelegatingMessageConverter(new Jackson2JsonMessageConverter(objectMapper));
    }

}
