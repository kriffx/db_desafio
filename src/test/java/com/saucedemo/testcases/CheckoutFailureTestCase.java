package com.saucedemo.testcases;

import com.saucedemo.steps.CheckoutFailureStep;
import com.saucedemo.utils.BaseTest;
import com.saucedemo.webdrivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class CheckoutFailureTestCase extends BaseTest {
    private WebDriver driver() {
        return DriverManager.getDriver();
    }

    @Test(
            description = "CT-002, Tentar continuar sem preencher os campos obrigatórios",
            groups = {"web"}
    )
    public void validarErroCamposObrigatoriosCheckoutTest() throws Exception {
        CheckoutFailureStep checkoutFailureStep = new CheckoutFailureStep(driver());
        checkoutFailureStep.validarErroAoNaoPreencherCamposObrigatorios();
    }

    @Test(
            description = "CT-003, Tentar continuar preenchendo apenas o campo FirstName",
            groups = {"web"}
    )
    public void validarErroAoPreencherApenasPrimeiroNomeTest() throws Exception {
        CheckoutFailureStep checkoutFailureStep = new CheckoutFailureStep(driver());
        checkoutFailureStep.validarErroAoPreencherSomenteCampoFirstName();
    }

    @Test(
            description = "CT-004, Tentar continuar preenchendo apenas o campo LastName",
            groups = {"web"}
    )
    public void validarErroAoPreencherApenasSobrenomeTest() throws Exception {
        CheckoutFailureStep checkoutFailureStep = new CheckoutFailureStep(driver());
        checkoutFailureStep.validarErroAoPreencherSomenteCampoLastName();
    }

    @Test(
            description = "CT-005, Tentar continuar preenchendo apenas o campo PostalCode",
            groups = {"web"}
    )
    public void validarErroAoPreencherApenasCodigoPostalTest() throws Exception {
        CheckoutFailureStep checkoutFailureStep = new CheckoutFailureStep(driver());
        checkoutFailureStep.validarErroAoPreencherSomenteCampoPostalCode();
    }

    @Test(
            description = "CT-006, Tentar continuar preenchendo os campos obrigatórios com apenas 2 caracteres",
            groups = {"web", "BUG"}
    )
    public void validarErroAoPreencherOsCamposApenasDoisCaracteresTest() throws Exception {
        CheckoutFailureStep checkoutFailureStep = new CheckoutFailureStep(driver());
        checkoutFailureStep.validarErroAoPreencherOsCamposMaximoDoisCaracteres();
    }

    @Test(
            description = "CT-007, Tentar continuar preenchendo os campos obrigatórios com mais de caracteres",
            groups = {"web", "BUG"}
    )
    public void validarErroAoPreencherCamposComExcessoDeCaracteresTest() throws Exception {
        CheckoutFailureStep checkoutFailureStep = new CheckoutFailureStep(driver());
        checkoutFailureStep.validarErroAoPreencherCamposComExcessoDeCaracteres();
    }

    @Test(
            description = "CT-008, Tentar continuar preenchendo os campos obrigatórios com números ou caracteres especiais",
            groups = {"web", "BUG"}
    )
    public void validarErroAoPreencherCamposComNumeroECaracteresEspeciaisTest() throws Exception {
        CheckoutFailureStep checkoutFailureStep = new CheckoutFailureStep(driver());
        checkoutFailureStep.validarErroAoPreencherCamposComNumeroECaracteresEspeciais();
    }

    @Test(
            description = "CT-009, Tentar continuar preenchendo o campo postal code com letras",
            groups = {"web", "BUG"}
    )
    public void validarErroAoPreencherCamposComLetrasTest() throws Exception {
        CheckoutFailureStep checkoutFailureStep = new CheckoutFailureStep(driver());
        checkoutFailureStep.validarErroAoPreencherCampoPostalCodeComLetras();
    }
}