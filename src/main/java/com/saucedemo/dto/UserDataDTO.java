package com.saucedemo.dto;

public class UserDataDTO {
    public static UserModelDTO dto = new UserModelDTO();

    public static UserModelDTO userData() {
        dto.setUsername("standard_user");
        dto.setPassword("secret_sauce");
        return new UserModelDTO(dto.getUsername(), userData().getPassword());
    }
}