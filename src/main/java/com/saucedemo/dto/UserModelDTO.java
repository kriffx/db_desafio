package com.saucedemo.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserModelDTO {
    String username;
    String password;
    String firstName;
    String lastName;
    String postalCode;

    public UserModelDTO() {

    }

    public UserModelDTO(String username, String password, String firstName, String lastName, String postalCode) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
    }
}