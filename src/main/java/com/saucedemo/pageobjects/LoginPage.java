package com.saucedemo.pageobjects;

import com.saucedemo.utils.WaitElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private final WaitElement wait;

    public LoginPage(WebDriver driver) {
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
}
