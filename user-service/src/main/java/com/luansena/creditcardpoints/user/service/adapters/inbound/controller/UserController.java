package com.luansena.creditcardpoints.user.service.adapters.inbound.controller;

import com.luansena.creditcardpoints.user.service.adapters.inbound.converter.UserRequestToUserConverter;
import com.luansena.creditcardpoints.user.service.adapters.inbound.dto.UserRequest;
import com.luansena.creditcardpoints.user.service.adapters.outbound.persistence.UserRepositoryAdapter;
import com.luansena.creditcardpoints.user.service.adapters.outbound.persistence.dto.UserDTO;
import com.luansena.creditcardpoints.user.service.adapters.outbound.persistence.dto.UserToUserDTOConverter;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepositoryAdapter userRepositoryAdapter;

    public UserController(UserRepositoryAdapter userRepositoryAdapter) {
        this.userRepositoryAdapter = userRepositoryAdapter;
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserRequest userRequest) {
        UserDTO userSaved = UserToUserDTOConverter.convert(userRepositoryAdapter.save(UserRequestToUserConverter.convert(userRequest)));
        return ResponseEntity.ok(userSaved);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = UserToUserDTOConverter.convertAll(userRepositoryAdapter.findAll());
        return ResponseEntity.ok(users);
    }

    @GetMapping("/login/{login}")
    public ResponseEntity<UserDTO> getByLogin(@PathVariable String login) {
        return userRepositoryAdapter.findByLogin(login)
            .map(user -> ResponseEntity.ok(UserToUserDTOConverter.convert(user)))
            .orElse(ResponseEntity.notFound().build());
    }
}
