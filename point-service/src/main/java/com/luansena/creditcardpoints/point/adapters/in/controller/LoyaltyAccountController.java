package com.luansena.creditcardpoints.point.adapters.in.controller;

import com.luansena.creditcardpoints.point.domain.ports.out.LoyaltyAccountRepositoryPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/accounts")
public class LoyaltyAccountController {
    private final LoyaltyAccountRepositoryPort loyaltyAccountRepositoryPort;

    public LoyaltyAccountController(LoyaltyAccountRepositoryPort loyaltyAccountRepositoryPort) {
        this.loyaltyAccountRepositoryPort = loyaltyAccountRepositoryPort;
    }

    @GetMapping("/{cardId}/points")
    public ResponseEntity<BigDecimal> getPoints(@PathVariable Long cardId) {
        BigDecimal points = loyaltyAccountRepositoryPort.getCurrentPoints(cardId);
        return ResponseEntity.ok(points);
    }
}

