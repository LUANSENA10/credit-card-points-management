package com.luansena.creditcardpoints.point.adapters.out.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_loyalty_accounts")
public class LoyaltyAccountEntity {

    @Id
    @Column(name = "card_id")
    private Long cardId;

    @Column(name = "current_points", nullable = false)
    private BigDecimal currentPoints;

    public LoyaltyAccountEntity() {}

    public LoyaltyAccountEntity(Long cardId, BigDecimal currentPoints) {
        this.cardId = cardId;
        this.currentPoints = currentPoints;
    }

    // Getters e Setters
    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public BigDecimal getCurrentPoints() {
        return currentPoints;
    }

    public void setCurrentPoints(BigDecimal currentPoints) {
        this.currentPoints = currentPoints;
    }
}
