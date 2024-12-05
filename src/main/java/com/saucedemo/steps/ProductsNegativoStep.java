package com.saucedemo.steps;

import com.aventstack.extentreports.Status;
import com.saucedemo.pageobjects.ProductsPage;
import com.saucedemo.pageobjects.CheckoutYourCartPage;
import com.saucedemo.support.AutenticacaoECheckout;
import com.saucedemo.utils.Report;
import org.openqa.selenium.WebDriver;

import static com.saucedemo.widgets.Element.*;

public class ProductsNegativoStep {
    private final WebDriver driver;
    private final AutenticacaoECheckout loginUser;
    private final ProductsPage productsPage;
    private final CheckoutYourCartPage yourCart;

    public ProductsNegativoStep(WebDriver _driver) {
        driver = _driver;
        loginUser = new AutenticacaoECheckout(_driver);
        productsPage = new ProductsPage(_driver);
        yourCart = new CheckoutYourCartPage(_driver);
    }

    public void validarDoCarrinhoAposRecarregarPagina() throws Exception {
        loginUser.getAutenticacaoLogin();
        Report.logCapture(Status.INFO, "Redirecionado tela de Products");
        click(productsPage.segundoItemAddToCartButton());
        driver.navigate().refresh();
        click(productsPage.iconeDoCarrinhoButton());
        Report.logCapture(Status.INFO, "Redirecionado tela de Your Cart");
        driver.navigate().refresh();
        validarSeItensMantemNoCarrinho();
    }

    private void validarSeItensMantemNoCarrinho() throws Exception {
        assertEquals(yourCart.quantidadeDoProdutoLabel(), "1");
        assertEquals(yourCart.verificarONomeDoSegundoItemLabel(), "Sauce Labs Fleece Jacket");
        assertEquals(yourCart.descricoesDoProdutoLabel(), "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.");
    }

    public void adicionarERemoverProdutosDoCarrinho() throws Exception {
        loginUser.getAutenticacaoLogin();
        Report.logCapture(Status.INFO, "Redirecionado tela de Products");
        click(productsPage.primeiroItemAddToCartButton());
        click(productsPage.segundoItemAddToCartButton());
        click(productsPage.iconeDoCarrinhoButton());
        Report.logCapture(Status.INFO, "Redirecionado tela de Your Cart");
        validarSeCarrinhoEstaVazio();
    }

    public void adicionarRemoverProdutosEValidarFinalizacaoCompraComCarrinhoVazio() throws Exception {
        loginUser.getAutenticacaoLogin();
        Report.logCapture(Status.INFO, "Redirecionado tela de Products");
        click(productsPage.primeiroItemAddToCartButton());
        click(productsPage.segundoItemAddToCartButton());
        click(productsPage.iconeDoCarrinhoButton());
        Report.logCapture(Status.INFO, "Redirecionado tela de Your Cart");
        validarSeCarrinhoEstaVazio();
        if(yourCart.checkoutButton().isDisplayed()) {
            click(yourCart.checkoutButton());
            Report.logCapture(Status.FAIL, "O sistema permitiu itens vazios no carrinho e prosseguiu para finalizar a compra. O sistema deverá impedir o botão quando os itens estão vazios no carrinho.");
        }
    }

    private void validarSeCarrinhoEstaVazio() throws Exception {
        if (yourCart.verificarONomeDoPrimeiroItemLabel().isDisplayed() &&
                yourCart.verificarONomeDoSegundoItemLabel().isDisplayed()) {
            click(yourCart.primeiroItemRemoveButton());
            click(yourCart.segundoItemRemoveButton());
            Report.logCapture(Status.PASS, "Os itens do carrinho estão vazios.");
        } else {
            Report.logCapture(Status.FAIL, "Os itens do carrinho não estão vazios.");
            assertEquals(yourCart.verificarONomeDoPrimeiroItemLabel(), "Sauce Labs Backpack", "O primeiro item deveria estar vazio.");
            assertEquals(yourCart.verificarONomeDoSegundoItemLabel(), "Sauce Labs Fleece Jacket", "O segundo item deveria estar vazio.");
        }
    }
}