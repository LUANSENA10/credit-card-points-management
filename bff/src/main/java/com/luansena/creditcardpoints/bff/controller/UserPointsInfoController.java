package com.luansena.creditcardpoints.bff.controller;

import com.luansena.creditcardpoints.bff.adapters.inbound.dto.JwtResponse;
import com.luansena.creditcardpoints.bff.adapters.inbound.dto.LoginRequest;
import com.luansena.creditcardpoints.bff.exception.AuthenticationException;
import com.luansena.creditcardpoints.bff.security.JwtUtil;
import com.luansena.creditcardpoints.bff.service.UserPointsInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-info")
public class UserPointsInfoController {
    private final UserPointsInfoService userPointsInfoService;

    public UserPointsInfoController(UserPointsInfoService userPointsInfoService) {
        this.userPointsInfoService = userPointsInfoService;
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest request) {
        boolean authenticated = userPointsInfoService.authenticateUser(request.getLogin(), request.getPassword());
        if (!authenticated) {
            throw new AuthenticationException("Login ou senha inválidos");
        }
        String token = JwtUtil.generateToken(request.getLogin());
        return ResponseEntity.ok(new JwtResponse(token));
    }
}
