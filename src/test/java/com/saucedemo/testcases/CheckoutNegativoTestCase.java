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
            groups = {"web"}
    )
    public void validarErroCamposObrigatoriosCheckoutTest() throws Exception {
        CheckoutNegativoStep checkoutNegativoStep = new CheckoutNegativoStep(driver());
        checkoutNegativoStep.validarErroAoNaoPreencherCamposObrigatorios();
    }

    @Test(
            description = "CT-003, Tentar continuar preenchendo apenas o campo FirstName",
            groups = {"web"}
    )
    public void validarErroAoPreencherApenasPrimeiroNomeTest() throws Exception {
        CheckoutNegativoStep checkoutNegativoStep = new CheckoutNegativoStep(driver());
        checkoutNegativoStep.validarErroAoPreencherSomenteCampoFirstName();
    }

    @Test(
            description = "CT-004, Tentar continuar preenchendo apenas o campo LastName",
            groups = {"web"}
    )
    public void validarErroAoPreencherApenasSobrenomeTest() throws Exception {
        CheckoutNegativoStep checkoutNegativoStep = new CheckoutNegativoStep(driver());
        checkoutNegativoStep.validarErroAoPreencherSomenteCampoLastName();
    }

    @Test(
            description = "CT-005, Tentar continuar preenchendo apenas o campo PostalCode",
            groups = {"web"}
    )
    public void validarErroAoPreencherApenasCodigoPostalTest() throws Exception {
        CheckoutNegativoStep checkoutNegativoStep = new CheckoutNegativoStep(driver());
        checkoutNegativoStep.validarErroAoPreencherSomenteCampoPostalCode();
    }

    @Test(
            description = "CT-006, Tentar continuar preenchendo os campos obrigatórios com apenas 2 caracteres",
            groups = {"web", "BUG"}
    )
    public void validarErroAoPreencherOsCamposApenasDoisCaracteresTest() throws Exception {
        CheckoutNegativoStep checkoutNegativoStep = new CheckoutNegativoStep(driver());
        checkoutNegativoStep.validarErroAoPreencherOsCamposMaximoDoisCaracteres();
    }

    @Test(
            description = "CT-007, Tentar continuar preenchendo os campos obrigatórios com mais de caracteres",
            groups = {"web", "BUG"}
    )
    public void validarErroAoPreencherCamposComExcessoDeCaracteresTest() throws Exception {
        CheckoutNegativoStep checkoutNegativoStep = new CheckoutNegativoStep(driver());
        checkoutNegativoStep.validarErroAoPreencherCamposComExcessoDeCaracteres();
    }

    @Test(
            description = "CT-008, Tentar continuar preenchendo os campos obrigatórios com números ou caracteres especiais",
            groups = {"web", "BUG"}
    )
    public void validarErroAoPreencherCamposComNumeroECaracteresEspeciaisTest() throws Exception {
        CheckoutNegativoStep checkoutNegativoStep = new CheckoutNegativoStep(driver());
        checkoutNegativoStep.validarErroAoPreencherCamposComNumeroECaracteresEspeciais();
    }

    @Test(
            description = "CT-009, Tentar continuar preenchendo o campo postal code com letras",
            groups = {"web", "BUG"}
    )
    public void validarErroAoPreencherCamposComLetrasTest() throws Exception {
        CheckoutNegativoStep checkoutNegativoStep = new CheckoutNegativoStep(driver());
        checkoutNegativoStep.validarErroAoPreencherCampoPostalCodeComLetras();
    }
}