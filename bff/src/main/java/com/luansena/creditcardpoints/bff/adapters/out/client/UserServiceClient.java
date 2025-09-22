package com.luansena.creditcardpoints.bff.adapters.out.client;



import java.util.List;
import com.luansena.creditcardpoints.bff.adapters.in.dto.UserDTO;
import com.luansena.creditcardpoints.bff.adapters.in.dto.UserRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", url = "${user.service.url}")
public interface UserServiceClient {
    @PostMapping("/users")
    UserDTO createUser(@RequestBody UserRequest userRequest);

    @GetMapping("/users")
    List<UserDTO> getAllUsers();

    @GetMapping("/users/login/{login}")
    UserDTO getByLogin(@PathVariable("login") String login);
}
