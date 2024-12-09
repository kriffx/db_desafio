package com.saucedemo.steps;

import com.aventstack.extentreports.Status;
import com.saucedemo.pageobjects.InventoryItemPage;
import com.saucedemo.pageobjects.ProductsPage;
import com.saucedemo.support.AuthAndCheckout;
import com.saucedemo.utils.JsExecutor;
import com.saucedemo.utils.Report;
import org.openqa.selenium.WebDriver;

import static com.saucedemo.widgets.Element.*;
import static org.testng.AssertJUnit.assertTrue;

public class UserProblemStep {
    private final WebDriver driver;
    private final AuthAndCheckout autenticacao;
    private final ProductsPage products;
    private final InventoryItemPage inventoryItem;
    private final JsExecutor jse;

    public UserProblemStep(WebDriver _driver) {
        driver = _driver;
        autenticacao = new AuthAndCheckout(_driver);
        products = new ProductsPage(_driver);
        inventoryItem = new InventoryItemPage(_driver);
        jse = new JsExecutor();
    }

    public void validarSeImagemDoItemEstaPresente() throws Exception {
        autenticacao.realizarLoginComoUsuarioComProblema();
        Report.logCapture(Status.INFO, "Redirecionado para a tela de Products");
        verificarImagemDoPrimeiroItem();
    }

    private void verificarImagemDoPrimeiroItem() {
        boolean imagemPresente = jse.imagePresent(driver, products.imagePrimeiroItem());
        try {
            assertTrue("A imagem do item não está visível", imagemPresente);
            Report.logCapture(Status.PASS, "A imagem do item está visível");
        } catch (AssertionError e) {
            Report.logCapture(Status.FAIL, "A imagem do item não está visível");
            throw e;
        }
    }

    public void validarRemocaoDeItemDoCarrinhoPorUsuarioProblema() throws Exception {
        autenticacao.realizarLoginComoUsuarioComProblema();
        Report.logCapture(Status.INFO, "Redirecionado para tela de Products");
        click(products.primeiroItemAddToCartButton());
        assertEquals(products.quantidadesDosProdutosNoIconeDoCarrinhoLabel(), "1");
        click(products.removePrimeiroItemButton());
        assertEquals(products.quantidadesDosProdutosNoIconeDoCarrinhoLabel(), "0",
                "O ícone do carrinho não atualizou para 0 após remover o item. O botão de 'REMOVE' não está funcionando corretamente.");
    }

    public void validarNomeDeItemNaPaginaDeProductsEDeItem() throws Exception {
        autenticacao.realizarLoginComoUsuarioComProblema();
        Report.logCapture(Status.INFO, "Redirecionado para tela de Products");
        assertEquals(products.tituloDoPrimeiroItemLabel(), "Sauce Labs Backpack", "O nome do item está correto.");
        click(products.tituloDoPrimeiroItemButton());
        Report.logCapture(Status.INFO, "Redirecionado para a tela de Item");
        assertEquals(inventoryItem.tituloDoItemLabel(), "Sauce Labs Backpack",
                "O nome do item não está correto, ele é bem diferente do nome do item anterior.");
    }

    public void validarAdicaoDeItemDoCarrinhoNaPaginaDeProducts() throws Exception {
        autenticacao.realizarLoginComoUsuarioComProblema();
        Report.logCapture(Status.INFO, "Redirecionado para a tela de Products");
        click(products.terceiroItemAddToCartButton());
        assertEquals(products.quantidadesDosProdutosNoIconeDoCarrinhoLabel(), "1",
                "O produto é adicionado no carrinho.");
        click(products.segundoItemAddToCartButton());
        assertEquals(products.quantidadesDosProdutosNoIconeDoCarrinhoLabel(), "2",
                "O ícone do carrinho não atualizou para 2 após adicionou mais um item. O botão de 'ADD TO CART' do item(Sauce Labs Fleece Jacket) não está funcionando corretamente.");
    }

    public void validarAdicaoDeItemNaPaginaDoItem() throws Exception {
        autenticacao.realizarLoginComoUsuarioComProblema();
        Report.logCapture(Status.INFO, "Redirecionado para a tela de Products");
        click(products.primeiroItemAddToCartButton());
        click(products.tituloTerceiroDoItemButton());
        Report.logCapture(Status.INFO, "Redirecionado para a tela de Item");
        click(inventoryItem.addToCardButton());
        assertEquals(inventoryItem.quatidadeDoItemNoIconeDoCarrinhoLabel(), "2",
                "O ícone do carrinho não atualizou para 2 após adicionou mais um item.");
    }

    public void validarFluxoDeLoginEDoCarrinho() throws Exception {
        autenticacao.realizarLoginComoUsuarioComProblema();
        Report.logCapture(Status.INFO, "Redirecionado para a tela de Products");
        assertEquals(products.tituloDoSegundoDoItemLabel(), "Sauce Labs Fleece Jacket");
        click(products.tituloSegundoDoItemButton());
        Report.logCapture(Status.INFO, "Redirecionado para a tela de Item");
        assertEquals(inventoryItem.tituloDoItemLabel(), "Sauce Labs Fleece Jacket",
                "O nome do item não está correto, ele é bem diferente do nome do item anterior.");
        click(inventoryItem.addToCardButton());
        assertEquals(inventoryItem.quatidadeDoItemNoIconeDoCarrinhoLabel(), "1", "Adicionou o item ao carrinho");
        click(inventoryItem.iconeDoCarrinhoButton());
        Report.logCapture(Status.INFO, "Redirecionado para a tela de Your Cart");
    }
}