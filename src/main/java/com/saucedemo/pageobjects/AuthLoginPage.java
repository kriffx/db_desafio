package com.saucedemo.pageobjects;

import com.saucedemo.utils.WaitElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthLoginPage {
    private final WaitElement wait;

    public AuthLoginPage(WebDriver driver) {
        wait = new WaitElement(driver);
    }

    public WebElement usernameTextField() {
        return wait.toBeClickable(By.id("user-name"));
    }

    public WebElement passwordTextField() {
        return wait.toBeClickable(By.id("password"));
    }

    public WebElement loginButton() {
        return wait.toBeClickable(By.id("login-button"));
    }

    public WebElement obterMensagemDeErrorLabel() {
        return wait.visibilityOf(By.cssSelector("#login_button_container form h3"));
    }
}