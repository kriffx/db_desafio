package com.saucedemo.pageobjects;

import com.saucedemo.utils.WaitElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutYourInformationPage {
    private WaitElement wait;

    public CheckoutYourInformationPage(WebDriver driver) {
        wait = new WaitElement(driver);
    }

    public WebElement tituloCheckoutYourInformationNoTopoLabel() {
        return wait.visibilityOf(By.cssSelector("#contents_wrapper div.subheader"));
    }

    public WebElement firstNameTextField() {
        return wait.toBeClickable(By.id("first-name"));
    }

    public WebElement lastNameTextField() {
        return wait.toBeClickable(By.id("last-name"));
    }

    public WebElement postalCodeTextField() {
        return wait.toBeClickable(By.id("postal-code"));
    }

    public WebElement mensagemDeErroCamposObrigatoriosLabel() {
        return wait.visibilityOf(By.cssSelector("#checkout_info_container h3"));
    }

    public WebElement continueCheckoutButton() {
        return wait.toBeClickable(By.cssSelector("#checkout_info_container div.checkout_buttons input"));
    }
}