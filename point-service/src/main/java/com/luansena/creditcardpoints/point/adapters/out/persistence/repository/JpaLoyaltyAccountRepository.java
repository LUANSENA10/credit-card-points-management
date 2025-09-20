package com.luansena.creditcardpoints.point.adapters.out.persistence.repository;

import com.luansena.creditcardpoints.point.adapters.out.persistence.entity.LoyaltyAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaLoyaltyAccountRepository extends JpaRepository<LoyaltyAccountEntity, Long> {
}
