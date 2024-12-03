package com.saucedemo.testcases;

import com.saucedemo.steps.ProductsNegativoStep;
import com.saucedemo.utils.BaseTest;
import com.saucedemo.webdrivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ProductsNegativoTestCase extends BaseTest {
    private WebDriver driver() {
        return DriverManager.getDriver();
    }

    @Test(
            description = "CT-002,  Adicionar o produto ao carrinho, ajustar a quantidade desejada e proceder ao checkout.",
            groups = {"web"}
    )
    public void adicionarEAjustarProdutoNoCarrinhoTest() throws Exception {
        ProductsNegativoStep productsNegativo = new ProductsNegativoStep(driver());
        productsNegativo.adicionarProdutoEAjustarQuantidadeNoCarrinho();
    }
}