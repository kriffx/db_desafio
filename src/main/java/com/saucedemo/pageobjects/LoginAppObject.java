package com.saucedemo.pageobjects;

import com.saucedemo.utils.WaitElement;
import org.openqa.selenium.WebDriver;

public class LoginAppObject {
    private final WaitElement wait;

    public LoginAppObject(WebDriver driver) {
        wait = new WaitElement(driver);
    }
}
