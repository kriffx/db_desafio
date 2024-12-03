package com.saucedemo.steps;

import com.aventstack.extentreports.Status;
import com.saucedemo.pageobjects.ProductsPage;
import com.saucedemo.pageobjects.YourCartPage;
import com.saucedemo.utils.AutenticacaoUser;
import com.saucedemo.utils.Report;
import org.openqa.selenium.WebDriver;

import static com.saucedemo.widgets.Element.*;

public class ProductsNegativoStep {
    private final AutenticacaoUser loginUser;
    private final ProductsPage productsPage;
    private final YourCartPage yourCartPage;

    public ProductsNegativoStep(WebDriver driver) {
        loginUser = new AutenticacaoUser(driver);
        productsPage = new ProductsPage(driver);
        yourCartPage = new YourCartPage(driver);
    }

    public void adicionarProdutoEAjustarQuantidadeNoCarrinho() throws Exception {
        Report.log(Status.INFO, "Tela de login");
        loginUser.getAutenticacaoLogin();
        Report.logCapture(Status.INFO, "Ser redirecionado tela de Products");
        click(productsPage.jaquetaProdutoAddToCartButton());
        assertEquals(productsPage.quantidadesDosProdutosNoIconeDoCarrinhoLabel(), "1");
        click(productsPage.iconeDoCarrinhoButton());
        Report.logCapture(Status.INFO, "Ser redirecionado tela de Your Cart");
        yourCartPage.quantidadeDoProdutoTextField().sendKeys("2");
        click(yourCartPage.checkoutButton());
    }

    public void nomeDoMetodo() {

    }
}