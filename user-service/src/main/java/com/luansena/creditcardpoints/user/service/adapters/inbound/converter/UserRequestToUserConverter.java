package com.luansena.creditcardpoints.user.service.adapters.inbound.converter;

import com.luansena.creditcardpoints.user.service.adapters.inbound.dto.UserRequest;
import com.luansena.creditcardpoints.user.service.domain.models.User;
import java.util.List;
import java.util.stream.Collectors;

public class UserRequestToUserConverter {
    public static User convert(UserRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        return user;
    }

    public static List<User> convertAll(List<UserRequest> requests) {
        return requests.stream()
                .map(UserRequestToUserConverter::convert)
                .collect(Collectors.toList());
    }
}
