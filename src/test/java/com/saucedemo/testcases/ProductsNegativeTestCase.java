package com.saucedemo.testcases;

import com.saucedemo.steps.ProductsNegativeStep;
import com.saucedemo.utils.BaseTest;
import com.saucedemo.webdrivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ProductsNegativeTestCase extends BaseTest {
    private WebDriver driver() {
        return DriverManager.getDriver();
    }

    @Test(
            description = "CT-002,  Adicionar o produto ao carrinho, ajustar a quantidade desejada e proceder ao checkout.",
            groups = {"web", "BUG"}
    )
    public void adicionarEAjustarProdutoNoCarrinhoTest() throws Exception {
        ProductsNegativeStep productsNegativo = new ProductsNegativeStep(driver());
        productsNegativo.adicionarProdutoEAjustarQuantidadeNoCarrinho();
    }

    @Test(
            description = "CT-001,  Adicionar produto ao carrinho e verificar persistência após recarregar a página.",
            groups = {"web"}
    )
    public void persistenciaDoItemNoCarrinhoTest() throws Exception {
        ProductsNegativeStep productsNegativo = new ProductsNegativeStep(driver());
        productsNegativo.validarDoCarrinhoAposRecarregarPagina();
    }

    @Test(
            description = "CT-001, Adicionar produto ao carrinho e remover todos os itens.",
            groups = {"web"}
    )
    public void adicionarProdutoERemoverItensDoCarrinhoTest() throws Exception {
        ProductsNegativeStep productsNegativo = new ProductsNegativeStep(driver());
        productsNegativo.adicionarERemoverProdutosDoCarrinho();
    }

    @Test(
            description = "CT-002, Adicionar produto ao carrinho e remover todos os itens e impedir finalizar a compra.",
            groups = {"web", "BUG"}
    )
    public void adicionarRemoverItensEValidarCarrinhoVazioTest() throws Exception {
        ProductsNegativeStep productsNegativo = new ProductsNegativeStep(driver());
        productsNegativo.adicionarRemoverProdutosEValidarFinalizacaoCompraComCarrinhoVazio();
    }
}