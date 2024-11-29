package com.saucedemo.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserModelDTO {
    String username;
    String password;

    public UserModelDTO() {

    }

    public UserModelDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }
}