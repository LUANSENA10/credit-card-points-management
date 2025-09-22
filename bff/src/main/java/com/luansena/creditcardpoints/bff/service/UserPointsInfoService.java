package com.luansena.creditcardpoints.bff.service;

import com.luansena.creditcardpoints.bff.adapters.out.client.UserServiceClient;
import com.luansena.creditcardpoints.bff.adapters.out.client.PointServiceClient;
import com.luansena.creditcardpoints.bff.adapters.in.dto.UserDTO;
import com.luansena.creditcardpoints.bff.adapters.inbound.dto.UserPointsInfoDTO;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class UserPointsInfoService {
    private final UserServiceClient userServiceClient;
    private final PointServiceClient pointServiceClient;

    public UserPointsInfoService(UserServiceClient userServiceClient, PointServiceClient pointServiceClient) {
        this.userServiceClient = userServiceClient;
        this.pointServiceClient = pointServiceClient;
    }

    public UserPointsInfoDTO getUserPointsInfo(String login) {
        UserDTO user = userServiceClient.getByLogin(login);
        if (user == null) return null;
        BigDecimal points = pointServiceClient.getPoints(user.getId());
        return new UserPointsInfoDTO(user.getName(), user.getEmail(), points);
    }

    public boolean authenticateUser(String login, String password) {
        UserDTO user = userServiceClient.getByLogin(login);
        if (user == null) return false;
        return user.getPassword() != null && user.getPassword().equals(password);
    }
}
