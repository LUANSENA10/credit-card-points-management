package com.luansena.creditcardpoints.user.service.adapters.outbound.persistence;

import com.luansena.creditcardpoints.user.service.adapters.inbound.converter.UserEntityToUserConverter;
import com.luansena.creditcardpoints.user.service.adapters.inbound.converter.UserToEntityConverter;
import com.luansena.creditcardpoints.user.service.adapters.outbound.persistence.repository.JpaUserRepository;
import com.luansena.creditcardpoints.user.service.domain.models.User;
import com.luansena.creditcardpoints.user.service.domain.ports.out.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class UserRepositoryAdapter implements UserRepository {

    private final JpaUserRepository jpaUserRepository;
    private final PasswordEncoder passwordEncoder;

    public UserRepositoryAdapter(JpaUserRepository jpaUserRepository, PasswordEncoder passwordEncoder) {
        this.jpaUserRepository = jpaUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        var userEntity = UserToEntityConverter.convert(user);
        jpaUserRepository.save(userEntity);
        return UserEntityToUserConverter.convert(userEntity);
    }

    @Override
    public List<User> findAll() {
        var users = jpaUserRepository.findAll();
         return UserEntityToUserConverter.convertAll(users);
    }

    @Override
    public Optional<User> findByLogin(String login) {
        return jpaUserRepository.findByLogin(login)
                .map(UserEntityToUserConverter::convert);
    }
}
