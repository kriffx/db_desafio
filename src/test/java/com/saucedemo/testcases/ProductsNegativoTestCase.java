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
            description = "CT-003,  Adicionar produto ao carrinho e verificar persistência após recarregar a página.",
            groups = {"web"}
    )
    public void persistenciaDoItemNoCarrinhoTest() throws Exception {
        ProductsNegativoStep productsNegativo = new ProductsNegativoStep(driver());
        productsNegativo.validarDoCarrinhoAposRecarregarPagina();
    }

    @Test(
            description = "CT-004, Adicionar produto ao carrinho e remover todos os itens.",
            groups = {"web"}
    )
    public void adicionarProdutoERemoverItensDoCarrinhoTest() throws Exception {
        ProductsNegativoStep productsNegativo = new ProductsNegativoStep(driver());
        productsNegativo.adicionarERemoverProdutosDoCarrinho();
    }

    @Test(
            description = "CT-005, Adicionar produto ao carrinho e remover todos os itens e impedir finalizar a compra.",
            groups = {"web"}
    )
    public void adicionarRemoverItensEValidarCarrinhoVazioTest() throws Exception {
        ProductsNegativoStep productsNegativo = new ProductsNegativoStep(driver());
        productsNegativo.adicionarRemoverProdutosEValidarFinalizacaoCompraComCarrinhoVazio();
    }
}