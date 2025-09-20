package com.luansena.creditcardpoints.point.adapters.out.persistence.repository;

import com.luansena.creditcardpoints.point.adapters.out.persistence.entity.LoyaltyAccountEntity;
import com.luansena.creditcardpoints.point.domain.model.LoyaltyAccount;
import com.luansena.creditcardpoints.point.domain.ports.out.LoyaltyAccountRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LoyaltyAccountRepositoryAdapter implements LoyaltyAccountRepositoryPort {

    private final JpaLoyaltyAccountRepository jpaRepository;

    public LoyaltyAccountRepositoryAdapter(JpaLoyaltyAccountRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Optional<LoyaltyAccount> findById(Long cardId) {
        return jpaRepository.findById(cardId)
                .map(entity -> new LoyaltyAccount(entity.getCardId(), entity.getCurrentPoints()));
    }

    @Override
    public LoyaltyAccount save(LoyaltyAccount account) {
        LoyaltyAccountEntity entity = new LoyaltyAccountEntity(account.getCardId(), account.getCurrentPoints());
        LoyaltyAccountEntity savedEntity = jpaRepository.save(entity);
        return new LoyaltyAccount(savedEntity.getCardId(), savedEntity.getCurrentPoints());
    }
}
