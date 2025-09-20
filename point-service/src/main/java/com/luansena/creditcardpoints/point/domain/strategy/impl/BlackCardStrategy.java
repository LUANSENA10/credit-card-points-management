package com.luansena.creditcardpoints.partner.domain.strategy.impl;

import com.luansena.creditcardpoints.partner.domain.strategy.PointsCalculationStrategy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;


@Component("BLACK")
public class BlackCardStrategy implements PointsCalculationStrategy {

    @Override
    public java.math.BigDecimal calculatePoints(java.math.BigDecimal transactionAmount) {
        return transactionAmount.multiply(new BigDecimal("1.00")).setScale(2, RoundingMode.DOWN);
    }
}
