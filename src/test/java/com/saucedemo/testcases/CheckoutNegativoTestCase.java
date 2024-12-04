package com.saucedemo.testcases;

import com.saucedemo.steps.CheckoutNegativoStep;
import com.saucedemo.utils.BaseTest;
import com.saucedemo.webdrivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class CheckoutNegativoTestCase extends BaseTest {
    private WebDriver driver() {
        return DriverManager.getDriver();
    }

    @Test(
            description = "CT-002, Tentar continuar sem preencher os campos obrigatórios",
            groups = "{web}"
    )
    public void validarErroCamposObrigatoriosCheckoutTest() throws Exception {
        CheckoutNegativoStep checkoutNegativoStep = new CheckoutNegativoStep(driver());
        checkoutNegativoStep.validarErroAoNaoPreencherCamposObrigatorios();
    }
}