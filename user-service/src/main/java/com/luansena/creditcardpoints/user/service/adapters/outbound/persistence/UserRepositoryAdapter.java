package com.luansena.creditcardpoints.user.service.adapters.outbound.persistence;

import com.luansena.creditcardpoints.user.service.adapters.inbound.converter.UserEntityToUserConverter;
import com.luansena.creditcardpoints.user.service.adapters.inbound.converter.UserToEntityConverter;
import com.luansena.creditcardpoints.user.service.adapters.outbound.persistence.repository.JpaUserRepository;
import com.luansena.creditcardpoints.user.service.domain.models.User;
import com.luansena.creditcardpoints.user.service.domain.ports.out.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserRepositoryAdapter implements UserRepository {

    private final JpaUserRepository jpaUserRepository;

    public UserRepositoryAdapter(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    public User save(User user) {
        var userEntity = UserToEntityConverter.convert(user);
        jpaUserRepository.save(userEntity);
        return UserEntityToUserConverter.convert(userEntity);
    }

    @Override
    public List<User> findAll() {
        var users = jpaUserRepository.findAll();
         return UserEntityToUserConverter.convertAll(users);
    }
}
