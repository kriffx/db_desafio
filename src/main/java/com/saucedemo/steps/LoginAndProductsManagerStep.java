package com.saucedemo.steps;

import com.aventstack.extentreports.Status;
import com.saucedemo.dto.UserDataDTO;
import com.saucedemo.pageobjects.*;
import com.saucedemo.utils.Report;
import org.openqa.selenium.WebDriver;

import static com.saucedemo.widgets.Element.*;

public class LoginAndProductsManagerStep {
    private final AuthLoginPage loginUsuario;
    private final ProductsPage products;
    private final CheckoutYourCartPage yourCart;
    private final CheckoutYourInformationPage yourInformation;
    private final CheckoutOverviewPage overview;
    private final FinishPage finish;

    public LoginAndProductsManagerStep(WebDriver driver) {
        loginUsuario = new AuthLoginPage(driver);
        products = new ProductsPage(driver);
        yourCart = new CheckoutYourCartPage(driver);
        yourInformation = new CheckoutYourInformationPage(driver);
        overview = new CheckoutOverviewPage(driver);
        finish = new FinishPage(driver);
    }

    public void iniciaFluxoDeCompra() throws Exception {
        autenticarUsuario();
        adicionaItensAoCarrinho();
        verificaProdutosNoCarrinhoECheckout();
        preencheInformacoesDeCheckout();
        verificarEFinalizarCheckout();
        verificarFinalizacaoELogout();
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
        click(products.primeiroItemAddToCartButton());
        click(products.segundoItemAddToCartButton());
        assertEquals(products.quantidadesDosProdutosNoIconeDoCarrinhoLabel(), "2");
        click(products.iconeDoCarrinhoButton());
    }

    private void verificaProdutosNoCarrinhoECheckout() throws Exception {
        Report.logCapture(Status.INFO, "Redirecionado para tela de Your Cart");
        assertEquals(yourCart.tituloYourCartNoTopoLabel(), "Your Cart");
        assertEquals(yourCart.verificarONomeDoPrimeiroItemLabel(), "Sauce Labs Backpack");
        assertEquals(yourCart.verificarOValorDoPrimeiroItemLabel(), "29.99");
        assertEquals(yourCart.verificarONomeDoSegundoItemLabel(), "Sauce Labs Fleece Jacket");
        assertEquals(yourCart.verificarOValorDoSegundoItemLabel(), "49.99");
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

    private void verificarFinalizacaoELogout() throws Exception {
        Report.logCapture(Status.INFO, "Redirecionado para tela de Finish");
        assertEquals(finish.tituloFinishNoTopoLabel(), "Finish");
        assertEquals(finish.tituloThankYouForYourOrderLabel(), "THANK YOU FOR YOUR ORDER");
        click(finish.tresListrasNoTopoButton());
        click(finish.logoutNoSideBarButton());
        Report.logCapture(Status.INFO,"Redirecionado para tela de Login");
    }
}