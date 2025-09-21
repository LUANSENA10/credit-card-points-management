package com.luansena.creditcardpoints.partner.domain.model;

import com.luansena.creditcardpoints.point.domain.model.CardType;

public class PointsTransaction {

    private String transactionId;
    private String userId;
    private CardType cardType;

    public PointsTransaction(String transactionId, String userId, CardType cardType) {
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

    public CardType getCardType() {
        return cardType;
    }
}
