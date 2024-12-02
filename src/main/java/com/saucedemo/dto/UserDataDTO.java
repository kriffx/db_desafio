package com.saucedemo.dto;

import com.github.javafaker.Faker;

import java.util.Locale;

public class UserDataDTO {
    public static UserModelDTO dto = new UserModelDTO();

    public static UserModelDTO userData() {
        //Faker faker = new Faker(new Locale("pt-BR"));
        dto.setUsername("standard_user");
        dto.setPassword("secret_sauce");
        dto.setFirstName("Ricardo");
        dto.setLastName("Costa");
        dto.setPostalCode("90619-900");
        return new UserModelDTO(dto.getUsername(), dto.getPassword(), dto.getFirstName(), dto.getLastName(), dto.getPostalCode());
    }
}