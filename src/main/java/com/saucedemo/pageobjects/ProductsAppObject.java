package com.saucedemo.pageobjects;

import com.saucedemo.utils.WaitElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsAppObject {
    private final WaitElement wait;

    public ProductsAppObject(WebDriver driver) {
        wait = new WaitElement(driver);
    }

    public WebElement quantidadesDosProdutosNoIconeDoCarrinhoLabel() {
        return wait.toBeClickable(By.cssSelector("#shopping_cart_container > a > span"));
    }

    public WebElement mochilaProdutoAddToCartButton() {
        return wait.toBeClickable(By.cssSelector("div:nth-child(1) > div.pricebar > button"));
    }
    
    public WebElement jaquetaProdutoAddToCartButton() {
        return wait.toBeClickable(By.cssSelector("div:nth-child(4) > div.pricebar > button"));
    }
}