package com.luansena.creditcardpoints.user.service.adapters.inbound.converter;

import com.luansena.creditcardpoints.user.service.adapters.outbound.persistence.entity.UserEntity;
import com.luansena.creditcardpoints.user.service.domain.models.User;
import java.util.List;
import java.util.stream.Collectors;

public class UserToEntityConverter {
    public static UserEntity convert(User user) {
        UserEntity entity = new UserEntity();
        entity.setUsername(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPassword(user.getPassword());
        entity.setLogin(user.getLogin());
        return entity;
    }

    public static List<UserEntity> convertAll(List<User> users) {
        return users.stream()
                .map(UserToEntityConverter::convert)
                .collect(Collectors.toList());
    }
}
