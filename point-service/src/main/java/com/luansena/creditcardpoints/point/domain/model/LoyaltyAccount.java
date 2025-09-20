package com.luansena.creditcardpoints.point.domain.model;

import java.math.BigDecimal;

public class LoyaltyAccount {

    private Long cardId;
    private BigDecimal currentPoints;


    public LoyaltyAccount(Long cardId, BigDecimal currentPoints) {
        if (cardId == null || currentPoints == null) {
            throw new IllegalArgumentException("Card ID and current points cannot be null.");
        }
        if (currentPoints.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Current points cannot be negative.");
        }
        this.cardId = cardId;
        this.currentPoints = currentPoints;
    }

    // Método de Fábrica (opcional, para criar uma nova conta)
    public static LoyaltyAccount createNew(Long cardId) {
        return new LoyaltyAccount(cardId, BigDecimal.ZERO);
    }

    // --- LÓGICA DE NEGÓCIO ---

    /**
     * Adiciona pontos à conta.
     * @param pointsToAdd O valor dos pontos a serem adicionados.
     */
    public void addPoints(BigDecimal pointsToAdd) {
        if (pointsToAdd == null || pointsToAdd.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Points to add must be positive.");
        }
        this.currentPoints = this.currentPoints.add(pointsToAdd);
    }

    /**
     * Tenta resgatar pontos da conta.
     * @param pointsToRedeem O valor dos pontos a serem resgatados.
     * @return true se o resgate for bem-sucedido, false caso contrário.
     */
    public boolean redeemPoints(BigDecimal pointsToRedeem) {
        if (pointsToRedeem == null || pointsToRedeem.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Points to redeem must be positive.");
        }

        if (this.currentPoints.compareTo(pointsToRedeem) < 0) {
            return false; // Pontos insuficientes
        }

        this.currentPoints = this.currentPoints.subtract(pointsToRedeem);
        return true;
    }

    // Getters
    public Long getCardId() {
        return cardId;
    }

    public BigDecimal getCurrentPoints() {
        return currentPoints;
    }
}
