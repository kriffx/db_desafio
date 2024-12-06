package com.saucedemo.dto;

public class UserDataDTO {
    public static UserModelDTO dto = new UserModelDTO();

    public static UserModelDTO userData() {
        dto.setUsername("standard_user");
        dto.setPassword("secret_sauce");
        dto.setFirstName("Ricardo");
        dto.setLastName("Costa");
        dto.setPostalCode("90619-900");
        dto.setProblemUser("problem_user");
        return new UserModelDTO(dto.getUsername(),
                                dto.getPassword(),
                                dto.getFirstName(),
                                dto.getLastName(),
                                dto.getPostalCode(),
                                dto.getProblemUser(),
                                dto.getLockedUser());
    }
}