package com.luansena.creditcardpoints.bff.security;

import com.luansena.creditcardpoints.bff.adapters.out.client.UserServiceClient;
import com.luansena.creditcardpoints.bff.adapters.in.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserServiceClient userServiceClient;

    public CustomUserDetailsService(UserServiceClient userServiceClient) {
        this.userServiceClient = userServiceClient;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserDTO user = userServiceClient.getByLogin(login);
        if (user == null) {
            throw new UsernameNotFoundException("Usuário não encontrado com login: " + login);
        }
        return new User(user.getLogin(), user.getPassword(), Collections.emptyList());
    }
}

