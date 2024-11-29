package com.saucedemo.steps;

import com.aventstack.extentreports.Status;
import com.saucedemo.dto.UserDataDTO;
import com.saucedemo.pageobjects.LoginAppObject;
import com.saucedemo.pageobjects.ProductsAppObject;
import com.saucedemo.utils.Report;
import org.openqa.selenium.WebDriver;

public class GerenciadorDeLoginEProdutos {
    private WebDriver driver;
    private final LoginAppObject loginUsuario;
    private final ProductsAppObject products;

    public GerenciadorDeLoginEProdutos(WebDriver _driver) {
        driver = _driver;
        loginUsuario = new LoginAppObject(_driver);
        products = new ProductsAppObject(_driver);
    }

    public void iniciaFluxoDeCompra() {
        efeturaLogin();
        adicionaItensAoCarrinho();
    }

    private void efeturaLogin() {
        Report.log(Status.INFO,"Acessar na tela de login");
        loginUsuario.usernameTextField().sendKeys(UserDataDTO.userData().getUsername());
        loginUsuario.passwordTextField().sendKeys(UserDataDTO.userData().getPassword());
        if(loginUsuario.loginButton().isDisplayed()) {
            loginUsuario.loginButton().click();
            Report.log(Status.PASS, "O botão 'Login' recebeu um clique.");
        } else {
            Report.logCapture(Status.FAIL, "O botão 'Login' não recebeu um clique");
        }
    }

    private void adicionaItensAoCarrinho() {
        Report.log(Status.INFO, "Redirecionado para tela de Products");
        products.mochilaProdutoAddToCartButton().click();
        products.jaquetaProdutoAddToCartButton().click();
        System.out.println("CARRINHO:" + products.quantidadesDosProdutosNoIconeDoCarrinhoLabel().getText());
    }
}