package com.luansena.creditcardpoints.bff.adapters.inbound.dto;

import java.math.BigDecimal;

public class UserPointsInfoDTO {
    private String name;
    private String email;
    private BigDecimal points;

    public UserPointsInfoDTO() {}
    public UserPointsInfoDTO(String name, String email, BigDecimal points) {
        this.name = name;
        this.email = email;
        this.points = points;
    }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public BigDecimal getPoints() { return points; }
    public void setPoints(BigDecimal points) { this.points = points; }
}

