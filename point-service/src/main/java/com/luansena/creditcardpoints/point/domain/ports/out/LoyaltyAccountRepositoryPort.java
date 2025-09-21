package com.luansena.creditcardpoints.point.domain.ports.out;

import com.luansena.creditcardpoints.point.domain.model.LoyaltyAccount;

import java.math.BigDecimal;
import java.util.Optional;

public interface LoyaltyAccountRepositoryPort {

    Optional<LoyaltyAccount> findById(Long cardId);

    void save(LoyaltyAccount account);

    BigDecimal getCurrentPoints(Long cardId);

    void decreasePoints(Long cardId, BigDecimal pointsToDecrease);
}
