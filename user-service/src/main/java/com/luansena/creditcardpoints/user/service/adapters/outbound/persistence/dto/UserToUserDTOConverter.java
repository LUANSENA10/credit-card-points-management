package com.luansena.creditcardpoints.user.service.adapters.outbound.persistence.dto;

import com.luansena.creditcardpoints.user.service.domain.models.User;
import java.util.List;
import java.util.stream.Collectors;

public class UserToUserDTOConverter {
    public static UserDTO convert(User user) {
        if (user == null) return null;
        return new UserDTO(
            user.getId(),
            user.getName(),
            user.getEmail(),
            user.getPassword()
        );
    }

    public static List<UserDTO> convertAll(List<User> users) {
        return users.stream()
                .map(UserToUserDTOConverter::convert)
                .collect(Collectors.toList());
    }
}

