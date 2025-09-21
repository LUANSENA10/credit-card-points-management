package com.luansena.creditcardpoints.point.adapters.in.controller;

import com.luansena.creditcardpoints.point.domain.model.CardType;

public class TransactionRequest implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private CardType cardType;
    private Double amount;
    private String transactionType;

    public TransactionRequest() {}

    public TransactionRequest(CardType cardType, Double amount, String transactionType) {
        this.cardType = cardType;
        this.amount = amount;
        this.transactionType = transactionType;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
}
