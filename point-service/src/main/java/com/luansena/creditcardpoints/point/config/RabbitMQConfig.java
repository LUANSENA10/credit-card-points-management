package com.luansena.creditcardpoints.point.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${transaction.authorized.queue}")
    private String queueName;

    @Bean
    public Queue queue() {
        return QueueBuilder.durable(queueName).build();
    }
}
