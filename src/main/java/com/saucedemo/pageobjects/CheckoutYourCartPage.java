package com.saucedemo.pageobjects;

import com.saucedemo.utils.WaitElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutYourCartPage {
    private final WaitElement wait;

    public CheckoutYourCartPage(WebDriver driver) {
        wait = new WaitElement(driver);
    }

    public WebElement tituloYourCartNoTopoLabel() {
        return wait.visibilityOf(By.cssSelector("#contents_wrapper > div.subheader"));
    }

    public WebElement verificarONomeDoPrimeiroItemLabel() {
        return wait.visibilityOf(By.cssSelector("#item_4_title_link div"));
    }

    public WebElement verificarOValorDoPrimeiroItemLabel() {
        return wait.visibilityOf(By.cssSelector("#cart_contents_container div:nth-child(3) div.item_pricebar div"));
    }

    public WebElement verificarONomeDoSegundoItemLabel() {
        return wait.visibilityOf(By.cssSelector("#item_5_title_link div"));
    }

    public WebElement verificarOValorDoSegundoItemLabel() {
        return wait.visibilityOf(By.cssSelector("#cart_contents_container div:nth-child(4) div.item_pricebar div"));
    }

    public WebElement quantidadeDoProdutoLabel() {
        return wait.toBeClickable(By.cssSelector("#cart_contents_container div.cart_quantity"));
    }

    public WebElement descricoesDoProdutoLabel() {
        return wait.visibilityOf(By.cssSelector("#cart_contents_container div.inventory_item_desc"));
    }

    public WebElement primeiroItemRemoveButton() {
        return wait.toBeClickable(By.cssSelector("#cart_contents_container div:nth-child(3) div button"));
    }

    public WebElement segundoItemRemoveButton() {
        return wait.toBeClickable(By.cssSelector("#cart_contents_container div:nth-child(4) div button"));
    }

    public WebElement checkoutButton() {
        return wait.toBeClickable(By.cssSelector("#cart_contents_container a.btn_action.checkout_button"));
    }
}