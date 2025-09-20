package com.luansena.creditcardpoints.point.domain.ports.in;

import java.math.BigDecimal;

public interface PointsServicePort {
    void addPoints(Long cardId, String cardType, BigDecimal transactionAmount);
}
