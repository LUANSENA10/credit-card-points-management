package com.luansena.creditcardpoints.point.adapters.in.controller;

import com.luansena.creditcardpoints.point.adapters.out.queue.TransactionProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);
    private final TransactionProducer transactionProducer;

    public TransactionController(TransactionProducer transactionProducer) {
        this.transactionProducer = transactionProducer;
    }

    @PostMapping
    public ResponseEntity<String> sendTransaction(@RequestBody TransactionRequest request) {
        logger.info("Recebendo transação: {}", request);
        transactionProducer.sendTransaction(request);
        return ResponseEntity.ok("Transação enviada para a fila com sucesso.");
    }
}

