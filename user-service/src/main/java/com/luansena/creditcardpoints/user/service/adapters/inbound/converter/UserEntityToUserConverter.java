package com.luansena.creditcardpoints.user.service.adapters.inbound.converter;

import com.luansena.creditcardpoints.user.service.adapters.outbound.persistence.entity.UserEntity;
import com.luansena.creditcardpoints.user.service.domain.models.User;
import java.util.List;
import java.util.stream.Collectors;

public class UserEntityToUserConverter {
    public static User convert(UserEntity entity) {
        if (entity == null) return null;
        User user = new User();
        user.setId(entity.getId());
        user.setName(entity.getUsername());
        user.setEmail(entity.getEmail());
        user.setPassword(entity.getPassword());
        user.setLogin(entity.getLogin());
        return user;
    }

    public static List<User> convertAll(List<UserEntity> entities) {
        return entities.stream()
                .map(UserEntityToUserConverter::convert)
                .collect(Collectors.toList());
    }
}
