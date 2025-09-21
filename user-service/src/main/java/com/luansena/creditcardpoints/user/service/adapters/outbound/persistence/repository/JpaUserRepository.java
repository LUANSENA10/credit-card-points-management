package com.luansena.creditcardpoints.user.service.adapters.outbound.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luansena.creditcardpoints.user.service.adapters.outbound.persistence.entity.UserEntity;

public interface JpaUserRepository extends JpaRepository<UserEntity, Long> {
}
