package com.luansena.creditcardpoints.partner.domain.strategy;

import java.math.BigDecimal;

public interface PointsCalculationStrategy {

    BigDecimal calculatePoints(BigDecimal transactionAmount);
}
