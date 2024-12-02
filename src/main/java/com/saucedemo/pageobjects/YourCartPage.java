package com.saucedemo.pageobjects;

import com.saucedemo.utils.WaitElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YourCartPage {
    private final WaitElement wait;

    public YourCartPage(WebDriver driver) {
        wait = new WaitElement(driver);
    }

    public WebElement tituloYourCartNoTopoLabel() {
        return wait.visibilityOf(By.cssSelector("#contents_wrapper > div.subheader"));
    }

    public WebElement verificarONomeDoProdutoMochilaLabel() {
        return wait.visibilityOf(By.cssSelector("#item_4_title_link div"));
    }

    public WebElement verificarOValorDoProdutoMochilaLabel() {
        return wait.visibilityOf(By.cssSelector("#cart_contents_container div:nth-child(3) div.item_pricebar div"));
    }

    public WebElement verificarONomeDoProdutoJaquetaLabel() {
        return wait.visibilityOf(By.cssSelector("#item_5_title_link div"));
    }

    public WebElement verificarOValorDoProdutoJaquetaLabel() {
        return wait.visibilityOf(By.cssSelector("#cart_contents_container div:nth-child(4) div.item_pricebar div"));
    }

    public WebElement checkoutButton() {
        return wait.toBeClickable(By.cssSelector("#cart_contents_container a.btn_action.checkout_button"));
    }
}