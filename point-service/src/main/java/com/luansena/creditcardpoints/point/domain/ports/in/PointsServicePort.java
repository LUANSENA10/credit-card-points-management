package com.luansena.creditcardpoints.point.domain.ports.in;

import com.luansena.creditcardpoints.point.domain.model.CardType;
import java.math.BigDecimal;

public interface PointsServicePort {
    void addPoints(Long cardId, CardType cardType, BigDecimal transactionAmount);
}
