package com.luansena.creditcardpoints.user.service.domain.ports.out;

import com.luansena.creditcardpoints.user.service.domain.models.User;
import java.util.List;
import java.util.Optional;

public interface UserRepository {

    User save(User user);
    List<User> findAll();
    Optional<User> findByLogin(String login);
}
