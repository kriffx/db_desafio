package com.saucedemo.steps;

import com.aventstack.extentreports.Status;
import com.saucedemo.dto.UserDataDTO;
import com.saucedemo.pageobjects.LoginPage;
import com.saucedemo.pageobjects.ProductsPage;
import com.saucedemo.pageobjects.YourCartPage;
import com.saucedemo.pageobjects.YourInformationPage;
import com.saucedemo.utils.Report;
import org.openqa.selenium.WebDriver;

import static com.saucedemo.widgets.Element.*;

public class GerenciadorDeLoginEProdutos {
    private WebDriver driver;
    private final LoginPage loginUsuario;
    private final ProductsPage products;
    private final YourCartPage yourCart;
    private final YourInformationPage yourInformation;

    public GerenciadorDeLoginEProdutos(WebDriver _driver) {
        driver = _driver;
        loginUsuario = new LoginPage(_driver);
        products = new ProductsPage(_driver);
        yourCart = new YourCartPage(_driver);
        yourInformation = new YourInformationPage(_driver);
    }

    public void iniciaFluxoDeCompra() throws Exception {
        autenticarUsuario();
        adicionaItensAoCarrinho();
        verificaProdutosNoCarrinhoECheckout();
        preencheInformacoesDeCheckout();
    }

    private void autenticarUsuario() throws Exception {
        Report.logCapture(Status.INFO, "Acessar na tela de login");
        loginUsuario.usernameTextField().sendKeys(UserDataDTO.userData().getUsername());
        loginUsuario.passwordTextField().sendKeys(UserDataDTO.userData().getPassword());
        click(loginUsuario.loginButton());
    }

    private void adicionaItensAoCarrinho() throws Exception {
        Report.logCapture(Status.INFO, "Redirecionado para tela de Products");
        assertEquals(products.paginaDeProductNoTopoLabel(), "Products");
        products.mochilaProdutoAddToCartButton().click();
        products.jaquetaProdutoAddToCartButton().click();
        assertEquals(products.quantidadesDosProdutosNoIconeDoCarrinhoLabel(), "2");
        products.iconeDoCarrinhoButton().click();
    }

    private void verificaProdutosNoCarrinhoECheckout() throws Exception {
        Report.logCapture(Status.INFO, "Redirecionado para tela de Your Cart");
        assertEquals(yourCart.paginaDeYourCartNoTopoLabel(), "Your Cart");
        assertEquals(yourCart.verificarONomeDoProdutoMochilaLabel(), "Sauce Labs Backpack");
        assertEquals(yourCart.verificarOValorDoProdutoMochilaLabel(), "29.99");
        assertEquals(yourCart.verificarONomeDoProdutoJaquetaLabel(), "Sauce Labs Fleece Jacket");
        assertEquals(yourCart.verificarOValorDoProdutoJaquetaLabel(), "49.99");
        click(yourCart.checkoutButton());
    }

    private void preencheInformacoesDeCheckout() throws Exception {
        Report.logCapture(Status.INFO, "Redirecionado para tela de Checkout: Your Information");
        assertEquals(yourInformation.paginaDeCheckoutYourInformationNoTopoLabel(), "Checkout: Your Information");
        yourInformation.firstNameTextField().sendKeys(UserDataDTO.dto.getFirstName());
        yourInformation.lastNameTextField().sendKeys(UserDataDTO.dto.getLastName());
        yourInformation.postalCodeTextField().sendKeys(UserDataDTO.dto.getPostalCode());
        click(yourInformation.continueButton());
    }
}