package com.saucedemo.steps;

import com.aventstack.extentreports.Status;
import com.saucedemo.dto.UserDataDTO;
import com.saucedemo.pageobjects.*;
import com.saucedemo.utils.Report;
import org.openqa.selenium.WebDriver;

import static com.saucedemo.widgets.Element.*;

public class GerenciadorDeLoginEProdutos {
    private WebDriver driver;
    private final LoginPage loginUsuario;
    private final ProductsPage products;
    private final YourCartPage yourCart;
    private final CheckoutYourInformationPage yourInformation;
    private final CheckoutOverviewPage overview;

    public GerenciadorDeLoginEProdutos(WebDriver _driver) {
        driver = _driver;
        loginUsuario = new LoginPage(_driver);
        products = new ProductsPage(_driver);
        yourCart = new YourCartPage(_driver);
        yourInformation = new CheckoutYourInformationPage(_driver);
        overview = new CheckoutOverviewPage(_driver);
    }

    public void iniciaFluxoDeCompra() throws Exception {
        autenticarUsuario();
        adicionaItensAoCarrinho();
        verificaProdutosNoCarrinhoECheckout();
        preencheInformacoesDeCheckout();
        verificarEFinalizarCheckout();
    }

    private void autenticarUsuario() throws Exception {
        Report.logCapture(Status.INFO, "Acessar na tela de login");
        loginUsuario.usernameTextField().sendKeys(UserDataDTO.userData().getUsername());
        loginUsuario.passwordTextField().sendKeys(UserDataDTO.userData().getPassword());
        click(loginUsuario.loginButton());
    }

    private void adicionaItensAoCarrinho() throws Exception {
        Report.logCapture(Status.INFO, "Redirecionado para tela de Products");
        assertEquals(products.tituloProductNoTopoLabel(), "Products");
        products.mochilaProdutoAddToCartButton().click();
        products.jaquetaProdutoAddToCartButton().click();
        assertEquals(products.quantidadesDosProdutosNoIconeDoCarrinhoLabel(), "2");
        products.iconeDoCarrinhoButton().click();
    }

    private void verificaProdutosNoCarrinhoECheckout() throws Exception {
        Report.logCapture(Status.INFO, "Redirecionado para tela de Your Cart");
        assertEquals(yourCart.tituloYourCartNoTopoLabel(), "Your Cart");
        assertEquals(yourCart.verificarONomeDoProdutoMochilaLabel(), "Sauce Labs Backpack");
        assertEquals(yourCart.verificarOValorDoProdutoMochilaLabel(), "29.99");
        assertEquals(yourCart.verificarONomeDoProdutoJaquetaLabel(), "Sauce Labs Fleece Jacket");
        assertEquals(yourCart.verificarOValorDoProdutoJaquetaLabel(), "49.99");
        click(yourCart.checkoutButton());
    }

    private void preencheInformacoesDeCheckout() throws Exception {
        Report.logCapture(Status.INFO, "Redirecionado para tela de Checkout: Your Information");
        assertEquals(yourInformation.tituloCheckoutYourInformationNoTopoLabel(), "Checkout: Your Information");
        yourInformation.firstNameTextField().sendKeys(UserDataDTO.dto.getFirstName());
        yourInformation.lastNameTextField().sendKeys(UserDataDTO.dto.getLastName());
        yourInformation.postalCodeTextField().sendKeys(UserDataDTO.dto.getPostalCode());
        click(yourInformation.continueCheckoutButton());
    }

    private void verificarEFinalizarCheckout() throws Exception {
        Report.logCapture(Status.INFO, "Redircionado para tela de Checkout: Overview");
        assertEquals(overview.tituloCheckoutOverviewLabel(), "Checkout: Overview");
        verificarPrimeiroItemCheckout();
        verificarSegundoItemCheckout();
        verificarInformacoesCheckout();
        click(overview.finishButton());
    }

    private void verificarPrimeiroItemCheckout() throws Exception {
        assertEquals(overview.quantidadePrimeiroItemLabel(), "1");
        assertEquals(overview.nomeDoPrimeiroItemCheckoutLabel(), "Sauce Labs Backpack");
        assertEquals(overview.valorDoPrimeiroItemCheckoutLabel(), "$29.99");
    }

    private void verificarSegundoItemCheckout() throws Exception {
        assertEquals(overview.quantidadeSegundoItemLabel(), "1");
        assertEquals(overview.nomeDoSegundoItemCheckoutLabel(), "Sauce Labs Fleece Jacket");
        assertEquals(overview.valorDoSegundoItemCheckoutLabel(), "$49.99");
    }

    private void verificarInformacoesCheckout() throws Exception {
        assertEquals(overview.obterFormaDePagamentoLabel(), "SauceCard #31337");
        assertEquals(overview.obterInformacoesDeEnvioLabel(), "FREE PONY EXPRESS DELIVERY!");
        assertEquals(overview.valorTotalDosItensLabel(), "Item total: $79.98");
        assertEquals(overview.valorComTaxasLabel(), "Tax: $6.40");
        assertEquals(overview.valorTotalFinalLabel(), "Total: $86.38");
    }
}