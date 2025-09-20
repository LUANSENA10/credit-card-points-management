package com.luansena.creditcardpoints.partner.domain.strategy.impl;

import com.luansena.creditcardpoints.partner.domain.strategy.PointsCalculationStrategy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component("PLATINUM")
public class PlatinumCardStrategy implements PointsCalculationStrategy {

    @Override
    public BigDecimal calculatePoints(BigDecimal transactionAmount) {
        return transactionAmount.divide(new BigDecimal("2.00"), 2, RoundingMode.DOWN);
    }
}
