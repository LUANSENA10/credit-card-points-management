package com.luansena.creditcardpoints.user.service.adapters.outbound.persistence.dto;

public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String login;

    public UserDTO() {}

    public UserDTO(Long id, String name, String email, String password, String login) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.login = login;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
