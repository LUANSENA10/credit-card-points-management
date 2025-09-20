package com.luansena.creditcardpoints.point.domain.ports.out;

import com.luansena.creditcardpoints.point.domain.model.LoyaltyAccount;

import java.util.Optional;

public interface LoyaltyAccountRepositoryPort {

    Optional<LoyaltyAccount> findById(Long cardId);

    LoyaltyAccount save(LoyaltyAccount account);
}
