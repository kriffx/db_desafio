package com.saucedemo.support;

import com.aventstack.extentreports.Status;
import com.saucedemo.dto.UserDataDTO;
import com.saucedemo.pageobjects.AuthLoginPage;
import com.saucedemo.pageobjects.ProductsPage;
import com.saucedemo.pageobjects.CheckoutYourCartPage;
import com.saucedemo.utils.Report;
import org.openqa.selenium.WebDriver;

import static com.saucedemo.widgets.Element.*;

public class AuthAndCheckout {
    private final AuthLoginPage login;
    private final ProductsPage products;
    private final CheckoutYourCartPage yourCart;

    public AuthAndCheckout(WebDriver driver) {
        login = new AuthLoginPage(driver);
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

    public void getContaDoUsuarioProblema() throws Exception {
        Report.logCapture(Status.INFO, "Tela de login");
        login.usernameTextField().sendKeys(UserDataDTO.userData().getProblemUser());
        login.passwordTextField().sendKeys(UserDataDTO.userData().getPassword());
        click(login.loginButton());
    }
}