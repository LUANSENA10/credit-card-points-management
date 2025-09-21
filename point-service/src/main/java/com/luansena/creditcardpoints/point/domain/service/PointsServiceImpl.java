package com.luansena.creditcardpoints.point.domain.service;

import com.luansena.creditcardpoints.partner.domain.strategy.PointsCalculationStrategy;
import com.luansena.creditcardpoints.point.domain.model.CardType;
import com.luansena.creditcardpoints.point.domain.model.LoyaltyAccount;
import com.luansena.creditcardpoints.point.domain.ports.in.PointsServicePort;
import com.luansena.creditcardpoints.point.domain.ports.out.LoyaltyAccountRepositoryPort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

@Service
public class PointsServiceImpl implements PointsServicePort {

    private final LoyaltyAccountRepositoryPort accountRepository;
    private final Map<String, PointsCalculationStrategy> strategies;

    public PointsServiceImpl(LoyaltyAccountRepositoryPort accountRepository,
                             Map<String, PointsCalculationStrategy> strategies) {
        this.accountRepository = accountRepository;
        this.strategies = strategies;
    }

    @Override
    public void addPoints(Long cardId, CardType cardType, BigDecimal transactionAmount) {
        LoyaltyAccount account = accountRepository.findById(cardId)
                .orElseGet(() -> LoyaltyAccount.createNew(cardId)); // Se não existir, cria uma nova

        PointsCalculationStrategy strategy = strategies.get(cardType.name());
        if (strategy == null) {
            throw new IllegalArgumentException("Unsupported card type: " + cardType);
        }

        BigDecimal pointsToAdd = strategy.calculatePoints(transactionAmount);
        account.addPoints(pointsToAdd);

        accountRepository.save(account);
    }
}