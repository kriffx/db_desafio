package com.saucedemo.steps;

import com.aventstack.extentreports.Status;
import com.saucedemo.pageobjects.InventoryItemPage;
import com.saucedemo.pageobjects.ProductsPage;
import com.saucedemo.support.AuthAndCheckout;
import com.saucedemo.utils.JsExecutor;
import com.saucedemo.utils.Report;
import org.openqa.selenium.WebDriver;

import static com.saucedemo.widgets.Element.*;

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
        autenticacao.getContaDoUsuarioProblema();
        Report.logCapture(Status.INFO, "Redirecionado para a tela de Products");
        verificarImagemDoPrimeiroItem();
    }

    private void verificarImagemDoPrimeiroItem() {
        boolean imagemPresente = jse.imagePresent(driver, products.imagePrimeiroItem());
        if(imagemPresente) {
            Report.logCapture(Status.PASS, "A imagem do item esta visível");
        } else {
            Report.logCapture(Status.FAIL, "A Imagem do item nao esta visível");
        }
    }

    public void validarRemocaoDeItemDoCarrinhoPorUsuarioProblema() throws Exception {
        autenticacao.getContaDoUsuarioProblema();
        Report.logCapture(Status.INFO, "Redirecionado para tela de Products");
        click(products.primeiroItemAddToCartButton());
        assertEquals(products.quantidadesDosProdutosNoIconeDoCarrinhoLabel(), "1");
        click(products.removePrimeiroItemButton());
        assertEquals(products.quantidadesDosProdutosNoIconeDoCarrinhoLabel(), "0",
                "O ícone do carrinho não atualizou para 0 após remover o item. O botão de 'REMOVE' não está funcionando corretamente.");
    }

    public void validarNomeDeItemNaPaginaDeProductsEDeItem() throws Exception {
        autenticacao.getContaDoUsuarioProblema();
        Report.logCapture(Status.INFO, "Redirecionado para tela de Products");
        assertEquals(products.tituloDoPrimeiroItemLabel(), "Sauce Labs Backpack", "O nome do item está correto.");
        click(products.tituloDoPrimeiroItemButton());
        Report.logCapture(Status.INFO, "Redirecionado para a tela de Item");
        assertEquals(inventoryItem.tituloDoItemLabel(), "Sauce Labs Backpack",
                "O nome do item não está correto, ele é bem diferente do nome do item anterior.");
    }

    public void validarAdicionaDeItemDoCarrinhoPorUsuarioProblema() throws Exception {
        autenticacao.getContaDoUsuarioProblema();
        Report.logCapture(Status.INFO, "Redirecionado para a tela de Products");
        click(products.terceiroItemAddToCartButton());
        assertEquals(products.quantidadesDosProdutosNoIconeDoCarrinhoLabel(), "1", "O produto é adicionado no carrinho.");
        click(products.segundoItemAddToCartButton());
        assertEquals(products.quantidadesDosProdutosNoIconeDoCarrinhoLabel(), "2",
                "O ícone do carrinho não atualizou para 2 após adicionou mais um item. O botão de 'ADD TO CART' do item(Sauce Labs Fleece Jacket) não está funcionando corretamente.");
    }
}