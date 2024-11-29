package com.saucedemo.steps;

import com.aventstack.extentreports.Status;
import com.saucedemo.dto.UserDataDTO;
import com.saucedemo.pageobjects.LoginPage;
import com.saucedemo.pageobjects.ProductsPage;
import com.saucedemo.pageobjects.YourCartPage;
import com.saucedemo.utils.Report;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GerenciadorDeLoginEProdutos {
    private WebDriver driver;
    private final LoginPage loginUsuario;
    private final ProductsPage products;
    private final YourCartPage yourCart;

    public GerenciadorDeLoginEProdutos(WebDriver _driver) {
        driver = _driver;
        loginUsuario = new LoginPage(_driver);
        products = new ProductsPage(_driver);
        yourCart = new YourCartPage(_driver);
    }

    public void iniciaFluxoDeCompra() {
        autenticarUsuario();
        adicionaItensAoCarrinho();
        verificaProdutosNoCarrinhoECheckout();
    }

    private void autenticarUsuario() {
        Report.logCapture(Status.INFO, "Acessar na tela de login");
        loginUsuario.usernameTextField().sendKeys(UserDataDTO.userData().getUsername());
        loginUsuario.passwordTextField().sendKeys(UserDataDTO.userData().getPassword());
        if (loginUsuario.loginButton().isDisplayed()) {
            loginUsuario.loginButton().click();
            Report.log(Status.PASS, "O botão 'Login' recebeu um clique.");
        } else {
            Report.logCapture(Status.FAIL, "O botão 'Login' não recebeu um clique");
        }
    }

    private void adicionaItensAoCarrinho() {
        Report.logCapture(Status.INFO, "Redirecionado para tela de Products");
        Assert.assertEquals("Products", products.paginaDeProductNoTopoLabel().getText());
        products.mochilaProdutoAddToCartButton().click();
        products.jaquetaProdutoAddToCartButton().click();
        Assert.assertEquals("2", products.quantidadesDosProdutosNoIconeDoCarrinhoLabel().getText());
        products.iconeDoCarrinhoButton().click();
    }

    private void verificaProdutosNoCarrinhoECheckout() {
        Report.logCapture(Status.INFO, "Redirecionado para tela de Your Cart");
        Assert.assertEquals("Your Cart", yourCart.paginaDeYourCartNoTopoLabel().getText());
        Assert.assertEquals("Sauce Labs Backpack", yourCart.verificarONomeDoProdutoMochilaLabel().getText());
        Assert.assertEquals("29.99", yourCart.verificarOValorDoProdutoMochilaLabel().getText());
        Assert.assertEquals("Sauce Labs Fleece Jacket", yourCart.verificarONomeDoProdutoJaquetaLabel().getText());
        Assert.assertEquals("49.99", yourCart.verificarOValorDoProdutoJaquetaLabel().getText());
        if(yourCart.checkoutButton().isDisplayed()) {
            yourCart.checkoutButton().click();
            Report.log(Status.PASS, "O botão de Chekcout recebeu um clique.");
        } else {
            Report.logCapture(Status.FAIL, "O botão de Checkout não recebeu um cilque.");
        }
    }
}