package com.luansena.creditcardpoints.partner.domain.model;

public class PointsTransaction {

    private String transactionId;
    private String userId;
    private String cardType;

    public PointsTransaction(String transactionId, String userId, String cardType) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.cardType = cardType;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getUserId() {
        return userId;
    }

    public String getCardType() {
        return cardType;
    }
}
