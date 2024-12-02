package com.saucedemo.pageobjects;

import com.saucedemo.utils.WaitElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutOverviewPage {
    private WaitElement wait;

    public CheckoutOverviewPage(WebDriver driver) {
        wait = new WaitElement(driver);
    }

    public WebElement tituloCheckoutOverviewLabel() {
        return wait.visibilityOf(By.cssSelector("#contents_wrapper div.subheader"));
    }

    public WebElement quantidadePrimeiroItemLabel() {
        return wait.visibilityOf(By.cssSelector("#checkout_summary_container div:nth-child(3) div.summary_quantity"));
    }

    public WebElement nomeDoPrimeiroItemCheckoutLabel() {
        return wait.visibilityOf(By.cssSelector("#item_4_title_link div"));
    }

    public WebElement valorDoPrimeiroItemCheckoutLabel() {
        return wait.visibilityOf(By.cssSelector("#checkout_summary_container div:nth-child(3) div.inventory_item_price"));
    }

    public WebElement quantidadeSegundoItemLabel() {
        return wait.visibilityOf(By.cssSelector("#checkout_summary_container div:nth-child(4) div.summary_quantity"));
    }

    public WebElement nomeDoSegundoItemCheckoutLabel() {
        return wait.visibilityOf(By.cssSelector("#item_5_title_link div"));
    }

    public WebElement valorDoSegundoItemCheckoutLabel() {
        return wait.visibilityOf(By.cssSelector("#checkout_summary_container div:nth-child(4) div.inventory_item_price"));
    }

    public WebElement obterFormaDePagamentoLabel() {
        return wait.visibilityOf(By.cssSelector("#checkout_summary_container div.summary_info div:nth-child(2)"));
    }

    public WebElement obterInformacoesDeEnvioLabel() {
        return wait.visibilityOf(By.cssSelector("#checkout_summary_container div.summary_info div:nth-child(4)"));
    }

    public WebElement valorTotalDosItensLabel() {
        return wait.visibilityOf(By.cssSelector("#checkout_summary_container div.summary_subtotal_label"));
    }

    public WebElement valorComTaxasLabel() {
        return wait.visibilityOf(By.cssSelector("#checkout_summary_container div.summary_tax_label"));
    }

    public WebElement valorTotalFinalLabel() {
        return wait.visibilityOf(By.cssSelector("#checkout_summary_container div.summary_total_label"));
    }

    public WebElement finishButton() {
        return wait.toBeClickable(By.cssSelector("a.btn_action.cart_button"));
    }
}