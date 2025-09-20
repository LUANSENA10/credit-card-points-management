package com.luansena.creditcardpoints.point.config;

import org.springframework.stereotype.Component;

@Component
public class TransactionMessageProducer {
    public void sendMessage(String message) {
        // Lógica para enviar a mensagem para o sistema de mensageria
        System.out.println("Enviando mensagem: " + message);
    }
}
