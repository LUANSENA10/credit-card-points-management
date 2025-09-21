package com.luansena.creditcardpoints.user.service.adapters.outbound.persistence.dto;

import com.luansena.creditcardpoints.user.service.adapters.outbound.persistence.entity.UserEntity;
import java.util.List;
import java.util.stream.Collectors;

public class UserEntityToUserDTOConverter {
    public static UserDTO convert(UserEntity entity) {
        if (entity == null) return null;
        return new UserDTO(
            entity.getId(),
            entity.getUsername(),
            entity.getEmail(),
            entity.getPassword()
        );
    }

    public static List<UserDTO> convertAll(List<UserEntity> entities) {
        return entities.stream()
                .map(UserEntityToUserDTOConverter::convert)
                .collect(Collectors.toList());
    }
}

