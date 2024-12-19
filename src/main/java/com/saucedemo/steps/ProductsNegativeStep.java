package com.saucedemo.steps;

import com.aventstack.extentreports.Status;
import com.saucedemo.pageobjects.ProductsPage;
import com.saucedemo.pageobjects.CheckoutYourCartPage;
import com.saucedemo.support.AuthAndCheckout;
import com.saucedemo.utils.JsExecutor;
import com.saucedemo.utils.Report;
import org.openqa.selenium.WebDriver;

import static com.saucedemo.widgets.Element.*;

public class ProductsNegativeStep {
    private final WebDriver driver;
    private final AuthAndCheckout auth;
    private final ProductsPage productsPage;
    private final CheckoutYourCartPage yourCart;

    public ProductsNegativeStep(WebDriver _driver) {
        driver = _driver;
        auth = new AuthAndCheckout(_driver);
        productsPage = new ProductsPage(_driver);
        yourCart = new CheckoutYourCartPage(_driver);
    }

    public void adicionarProdutoEAjustarQuantidadeNoCarrinho() throws Exception {
        Report.log(Status.INFO, "Tela de login");
        auth.realizarLogin();
        Report.logCapture(Status.INFO, "Redirecionado para a tela de Products");
        click(productsPage.segundoItemAddToCartButton());
        assertEquals(productsPage.quantidadesDosProdutosNoIconeDoCarrinhoLabel(), "1",
                "A quantidade do item foi ajustado correta.");
        click(productsPage.iconeDoCarrinhoButton());
        Report.logCapture(Status.INFO, "Redirecionado para a tela de Your Cart");
        JsExecutor.highlight(driver, yourCart.quantidadeDoProdutoLabel());
        yourCart.quantidadeDoProdutoLabel().sendKeys("2");
    }

    public void validarDoCarrinhoAposRecarregarPagina() throws Exception {
        auth.realizarLogin();
        Report.logCapture(Status.INFO, "Redirecionado para a tela de Products");
        click(productsPage.segundoItemAddToCartButton());
        driver.navigate().refresh();
        click(productsPage.iconeDoCarrinhoButton());
        Report.logCapture(Status.INFO, "Redirecionado para a tela de Your Cart");
        driver.navigate().refresh();
        validarSeItensMantemNoCarrinho();
    }

    private void validarSeItensMantemNoCarrinho() throws Exception {
        assertEquals(yourCart.quantidadeDoProdutoLabel(), "1", "A quantidade do item não está correta");
        assertEquals(yourCart.verificarONomeDoSegundoItemLabel(), "Sauce Labs Fleece Jacket",
                "O nome do segundo item não está correta");
        assertEquals(yourCart.descricoesDoProdutoLabel(),
                "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.",
                "As descrições do item estão incorretas.");
    }

    public void adicionarERemoverProdutosDoCarrinho() throws Exception {
        auth.realizarLogin();
        Report.logCapture(Status.INFO, "Redirecionado para a tela de Products");
        click(productsPage.primeiroItemAddToCartButton());
        click(productsPage.segundoItemAddToCartButton());
        click(productsPage.iconeDoCarrinhoButton());
        Report.logCapture(Status.INFO, "Redirecionado para a tela de Your Cart");
        validarSeCarrinhoEstaVazio();
    }

    public void adicionarRemoverProdutosEValidarFinalizacaoCompraComCarrinhoVazio() throws Exception {
        auth.realizarLogin();
        Report.logCapture(Status.INFO, "Redirecionado para a tela de Products");
        click(productsPage.primeiroItemAddToCartButton());
        click(productsPage.segundoItemAddToCartButton());
        click(productsPage.iconeDoCarrinhoButton());
        Report.logCapture(Status.INFO, "Redirecionado para a tela de Your Cart");
        validarSeCarrinhoEstaVazio();
        if (yourCart.checkoutButton().isDisplayed()) {
            click(yourCart.checkoutButton());
            Report.logCapture(Status.FAIL,
                    "O sistema permitiu itens vazios no carrinho e prosseguiu para finalizar a compra. O sistema deverá impedir o botão quando os itens estão vazios no carrinho.");
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
            assertEquals(yourCart.verificarONomeDoPrimeiroItemLabel(), "Sauce Labs Backpack",
                    "O primeiro item deveria estar vazio.");
            assertEquals(yourCart.verificarONomeDoSegundoItemLabel(), "Sauce Labs Fleece Jacket",
                    "O segundo item deveria estar vazio.");
        }
    }
}