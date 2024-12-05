package com.saucedemo.support;

import com.aventstack.extentreports.Status;
import com.saucedemo.dto.UserDataDTO;
import com.saucedemo.pageobjects.AutenticacaoLoginPage;
import com.saucedemo.pageobjects.ProductsPage;
import com.saucedemo.pageobjects.CheckoutYourCartPage;
import com.saucedemo.utils.Report;
import org.openqa.selenium.WebDriver;

import static com.saucedemo.widgets.Element.*;

public class AutenticacaoECheckout {
    private final AutenticacaoLoginPage login;
    private final ProductsPage products;
    private final CheckoutYourCartPage yourCart;

    public AutenticacaoECheckout(WebDriver driver) {
        login = new AutenticacaoLoginPage(driver);
        products = new ProductsPage(driver);
        yourCart = new CheckoutYourCartPage(driver);
    }

    public void getAutenticacaoLogin() throws Exception {
        Report.logCapture(Status.INFO, "Tela de login");
        login.usernameTextField().sendKeys(UserDataDTO.userData().getUsername());
        login.passwordTextField().sendKeys(UserDataDTO.userData().getPassword());
        click(login.loginButton());
    }

    public void getItensNoCarrinhoECheckout() throws Exception {
        Report.logCapture(Status.INFO,"Redirecionado para a tela de Products");
        click(products.primeiroItemAddToCartButton());
        click(products.iconeDoCarrinhoButton());
        click(yourCart.checkoutButton());
    }
}