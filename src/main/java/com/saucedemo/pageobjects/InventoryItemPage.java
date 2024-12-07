package com.saucedemo.pageobjects;

import com.saucedemo.utils.WaitElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryItemPage {
    private final WaitElement wait;

    public InventoryItemPage(WebDriver driver) {
        wait = new WaitElement(driver);
    }

    public WebElement tituloDoItemLabel() {
        return wait.visibilityOf(By.cssSelector("#inventory_item_container div.inventory_details_name"));
    }

    public WebElement quatidadeDoItemNoIconeDoCarrinhoLabel() {
        return wait.visibilityOf(By.cssSelector("#shopping_cart_container span"));
    }

    public WebElement addToCardButton() {
        return wait.toBeClickable(By.cssSelector("#inventory_item_container div div button"));
    }

    public WebElement iconeDoCarrinhoButton() {
        return wait.toBeClickable(By.id("shopping_cart_container"));
    }
}