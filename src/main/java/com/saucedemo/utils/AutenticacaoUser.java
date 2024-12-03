package com.saucedemo.utils;

import com.saucedemo.dto.UserDataDTO;
import com.saucedemo.pageobjects.AutenticacaoLoginPage;
import com.saucedemo.widgets.Element;
import org.openqa.selenium.WebDriver;

public class AutenticacaoUser {
    private final AutenticacaoLoginPage login;

    public AutenticacaoUser(WebDriver driver) {
        login = new AutenticacaoLoginPage(driver);
    }

    public void getAutenticacaoLogin() throws Exception {
        login.usernameTextField().sendKeys(UserDataDTO.userData().getUsername());
        login.passwordTextField().sendKeys(UserDataDTO.userData().getPassword());
        Element.click(login.loginButton());
    }
}