package com.saucedemo.testcases;

import com.saucedemo.steps.UserProblemStep;
import com.saucedemo.utils.BaseTest;
import com.saucedemo.webdrivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class UserProblemTest extends BaseTest {
    private WebDriver driver() {
        return DriverManager.getDriver();
    }

    @Test(
            description = "CT-001, Login com usuário problemático e verificação das imagens dos produtos",
            groups = {"web", "BUG"}

    )
    public void validarSeImagemDoItemEstaPresenteTest() throws Exception {
        UserProblemStep userProblemStep = new UserProblemStep(driver());
        userProblemStep.validarSeImagemDoItemEstaPresente();
    }

    @Test(
            description = "CT-001, Login com usuário problemático e verificação se o item foi remove ao carrinho",
            groups = {"web", "BUG"}

    )
    public void validarRemocaoDeItemDoCarrinhoTest() throws Exception {
        UserProblemStep userProblemStep = new UserProblemStep(driver());
        userProblemStep.validarRemocaoDeItemDoCarrinhoPorUsuarioProblema();
    }


    @Test(
            description = "CT-001, Login com usuário problemático e verificação se o nome do item está correto na pagina do item",
            groups = {"web", "BUG"}

    )
    public void validarNomeDoItemNaPaginaDeProductsEDeItemPorUsuarioProblemaTest() throws Exception {
        UserProblemStep userProblemStep = new UserProblemStep(driver());
        userProblemStep.validarNomeDeItemNaPaginaDeProductsEDeItem();
    }

    @Test(
            description = "CT-002, Login com usuário problemático e verificação se o item é adicionado ao carrinho na pagina de item",
            groups = {"web", "BUG"}

    )
    public void validarAdicionaDeItemDoCarrinhoTest() throws Exception {
        UserProblemStep userProblemStep = new UserProblemStep(driver());
        userProblemStep.validarAdicionaDeItemDoCarrinhoPorUsuarioProblema();
    }
}