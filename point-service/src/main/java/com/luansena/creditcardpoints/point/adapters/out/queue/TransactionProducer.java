package com.luansena.creditcardpoints.point.adapters.out.queue;

import com.luansena.creditcardpoints.point.adapters.in.controller.TransactionRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TransactionProducer {
    private static final Logger logger = LoggerFactory.getLogger(TransactionProducer.class);
    private final RabbitTemplate rabbitTemplate;

    @Value("${spring.transaction.authorized.queue}")
    private String transactionQueue;

    public TransactionProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendTransaction(TransactionRequest request) {
        logger.info("Enviando transação para a fila: {}", transactionQueue);
        rabbitTemplate.convertAndSend(transactionQueue, request.toString());
    }
}

