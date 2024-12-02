package com.saucedemo.steps;

import com.aventstack.extentreports.Status;
import com.saucedemo.dto.UserDataDTO;
import com.saucedemo.pageobjects.LoginPage;
import com.saucedemo.pageobjects.ProductsPage;
import com.saucedemo.pageobjects.YourCartPage;
import com.saucedemo.utils.Report;
import com.saucedemo.widgets.Element;
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

    public void iniciaFluxoDeCompra() throws Exception {
        autenticarUsuario();
        adicionaItensAoCarrinho();
        verificaProdutosNoCarrinhoECheckout();
    }

    private void autenticarUsuario() throws Exception {
        Report.logCapture(Status.INFO, "Acessar na tela de login");
        loginUsuario.usernameTextField().sendKeys(UserDataDTO.userData().getUsername());
        loginUsuario.passwordTextField().sendKeys(UserDataDTO.userData().getPassword());
        Element.click(loginUsuario.loginButton());
    }

    private void adicionaItensAoCarrinho() throws Exception {
        Report.logCapture(Status.INFO, "Redirecionado para tela de Products");
        Element.assertEquals(products.paginaDeProductNoTopoLabel(), "Products");
        products.mochilaProdutoAddToCartButton().click();
        products.jaquetaProdutoAddToCartButton().click();
        Element.assertEquals(products.quantidadesDosProdutosNoIconeDoCarrinhoLabel(), "2");
        products.iconeDoCarrinhoButton().click();
    }

    private void verificaProdutosNoCarrinhoECheckout() throws Exception {
        Report.logCapture(Status.INFO, "Redirecionado para tela de Your Cart");
        Element.assertEquals(yourCart.paginaDeYourCartNoTopoLabel(), "Your Cart");
        Element.assertEquals(yourCart.verificarONomeDoProdutoMochilaLabel(), "Sauce Labs Backpack");
        Element.assertEquals(yourCart.verificarOValorDoProdutoMochilaLabel(), "29.99");
        Element.assertEquals(yourCart.verificarONomeDoProdutoJaquetaLabel(), "Sauce Labs Fleece Jacket");
        Element.assertEquals(yourCart.verificarOValorDoProdutoJaquetaLabel(), "49.99");
        Element.click(yourCart.checkoutButton());
    }
}