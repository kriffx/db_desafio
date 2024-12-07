package com.saucedemo.pageobjects;

import com.saucedemo.utils.WaitElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {
    private final WaitElement wait;

    public ProductsPage(WebDriver driver) {
        wait = new WaitElement(driver);
    }

    public WebElement tituloProductNoTopoLabel() {
        return wait.visibilityOf(By.cssSelector("#inventory_filter_container div"));
    }

    public WebElement quantidadesDosProdutosNoIconeDoCarrinhoLabel() {
        return wait.visibilityOf(By.cssSelector("#shopping_cart_container > a > span"));
    }

    public WebElement tituloDoPrimeiroItemLabel() {
        return wait.visibilityOf(By.cssSelector("#item_4_title_link div"));
    }

    public WebElement tituloDoPrimeiroItemButton() {
        return wait.toBeClickable(By.id("item_4_title_link"));
    }

    public WebElement primeiroItemAddToCartButton() {
        return wait.toBeClickable(By.cssSelector("div:nth-child(1) > div.pricebar > button"));
    }
    
    public WebElement segundoItemAddToCartButton() {
        return wait.toBeClickable(By.cssSelector("div:nth-child(4) > div.pricebar > button"));
    }

    public WebElement tituloSegundoDoItemButton() {
        return wait.toBeClickable(By.id("item_5_title_link"));
    }

    public WebElement tituloDoSegundoDoItemLabel() {
        return wait.visibilityOf(By.cssSelector("#item_5_title_link div"));
    }

    public WebElement tituloTerceiroDoItemButton() {
        return wait.toBeClickable(By.id("item_0_title_link"));
    }

    public WebElement iconeDoCarrinhoButton() {
        return wait.toBeClickable(By.id("shopping_cart_container"));
    }

    public WebElement imagePrimeiroItem() {
        return wait.visibilityOf(By.cssSelector("#inventory_container div:nth-child(1) div.inventory_item_img"));
    }

    public WebElement removePrimeiroItemButton() {
        return wait.toBeClickable(By.cssSelector("#inventory_container div:nth-child(1) > div.pricebar button"));
    }

    public WebElement terceiroItemAddToCartButton() {
        return wait.toBeClickable(By.cssSelector("#inventory_container div:nth-child(2) > div.pricebar > button"));
    }
}