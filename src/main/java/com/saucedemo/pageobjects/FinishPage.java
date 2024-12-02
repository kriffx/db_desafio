package com.saucedemo.pageobjects;

import com.saucedemo.utils.WaitElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FinishPage {
    private WaitElement wait;

    public FinishPage(WebDriver driver) {
        wait = new WaitElement(driver);
    }

    public WebElement tituloFinishNoTopoLabel() {
        return wait.visibilityOf(By.cssSelector("#contents_wrapper div.subheader"));
    }

    public WebElement tituloThankYouForYourOrderLabel() {
        return wait.visibilityOf(By.cssSelector("#checkout_complete_container h2"));
    }

    public WebElement tresListrasNoTopoButton() {
        return wait.toBeClickable(By.cssSelector("#menu_button_container div:nth-child(3) button"));
    }

    public WebElement logoutNoSideBarButton() {
        return wait.toBeClickable(By.id("logout_sidebar_link"));
    }
}