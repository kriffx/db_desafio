package com.saucedemo.steps;

import com.aventstack.extentreports.Status;
import com.github.javafaker.Faker;
import com.saucedemo.dto.UserDataDTO;
import com.saucedemo.pageobjects.CheckoutYourInformationPage;
import com.saucedemo.support.AuthAndCheckout;
import com.saucedemo.utils.Report;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static com.saucedemo.widgets.Element.*;

public class CheckoutFailureStep {
    private final AuthAndCheckout authAndCheckout;
    private final CheckoutYourInformationPage yourInformation;

    public CheckoutFailureStep(WebDriver driver) {
        authAndCheckout = new AuthAndCheckout(driver);
        yourInformation = new CheckoutYourInformationPage(driver);
    }

    public void validarErroAoNaoPreencherCamposObrigatorios() throws Exception {
        authAndCheckout.realizarLogin();
        authAndCheckout.adicionarItensAoCarrinho();
        Report.logCapture(Status.INFO, "Redirecionado para a tela de Checkout: Your Information");
        click(yourInformation.continueCheckoutButton());
        assertEquals(yourInformation.mensagemDeErroCamposObrigatoriosLabel(), "Error: First Name is required", "Os campos são obrigatórios e foram preenchidos corretamente.");
        Report.logCapture(Status.INFO, "obter a mensagem de erro");
    }

    public void validarErroAoPreencherSomenteCampoFirstName() throws Exception {
        authAndCheckout.realizarLogin();
        authAndCheckout.adicionarItensAoCarrinho();
        Report.logCapture(Status.INFO, "Redirecionado para a tela de Checkout: Your Information");
        yourInformation.firstNameTextField().sendKeys(UserDataDTO.userData().getFirstName());
        click(yourInformation.continueCheckoutButton());
        assertEquals(yourInformation.mensagemDeErroCamposObrigatoriosLabel(), "Error: Last Name is required", "O campo 'LastName' é obrigatório e foi preenchido corretamente.");
        Report.logCapture(Status.INFO, "obter a mensagem de erro");
    }

    public void validarErroAoPreencherSomenteCampoLastName() throws Exception {
        authAndCheckout.realizarLogin();
        authAndCheckout.adicionarItensAoCarrinho();
        Report.logCapture(Status.INFO, "Redirecionado para a tela de Checkout: Your Information");
        yourInformation.lastNameTextField().sendKeys(UserDataDTO.userData().getLastName());
        click(yourInformation.continueCheckoutButton());
        assertEquals(yourInformation.mensagemDeErroCamposObrigatoriosLabel(), "Error: First Name is required", "O campo 'LastName' é obrigatório e foi preenchido corretamente.");
        Report.logCapture(Status.INFO, "obter a mensagem de erro");
    }

    public void validarErroAoPreencherSomenteCampoPostalCode() throws Exception {
        authAndCheckout.realizarLogin();
        authAndCheckout.adicionarItensAoCarrinho();
        Report.logCapture(Status.INFO, "Redirecionado para a tela de Checkout: Your Information");
        yourInformation.lastNameTextField().sendKeys(UserDataDTO.userData().getLastName());
        click(yourInformation.continueCheckoutButton());
        assertEquals(yourInformation.mensagemDeErroCamposObrigatoriosLabel(), "Error: First Name is required", "O campo 'Zip/PostalCode' é obrigatório e foi preenchido corretamente.");
        Report.logCapture(Status.INFO, "obter a mensagem de erro");
    }

    public void validarErroAoPreencherOsCamposMaximoDoisCaracteres() throws Exception {
        authAndCheckout.realizarLogin();
        authAndCheckout.adicionarItensAoCarrinho();
        Report.logCapture(Status.INFO, "Redirecionado para a tela de Checkout: Your Information");
        yourInformation.firstNameTextField().sendKeys("Ri");
        yourInformation.lastNameTextField().sendKeys("Co");
        yourInformation.postalCodeTextField().sendKeys("90");
        validarOSistemaBloqueiaAContinuidade();
    }

    public void validarErroAoPreencherCamposComExcessoDeCaracteres() throws Exception {
        authAndCheckout.realizarLogin();
        authAndCheckout.adicionarItensAoCarrinho();
        Report.logCapture(Status.INFO, "Redirecionado para a tela de Checkout: Your Information");
        yourInformation.firstNameTextField().sendKeys(Faker.instance().lorem().characters(300));
        yourInformation.lastNameTextField().sendKeys(Faker.instance().lorem().characters(300));
        yourInformation.postalCodeTextField().sendKeys(Faker.instance().lorem().characters(300));
        validarOSistemaBloqueiaAContinuidade();
    }

    public void validarErroAoPreencherCamposComNumeroECaracteresEspeciais() throws Exception {
        authAndCheckout.realizarLogin();
        authAndCheckout.adicionarItensAoCarrinho();
        Report.logCapture(Status.INFO, "Redirecionado para a tela de Checkout: Your Information");
        yourInformation.firstNameTextField().sendKeys("Ric@rd0!");
        yourInformation.lastNameTextField().sendKeys("C0st@123");
        yourInformation.postalCodeTextField().sendKeys("#90619@90");
        validarOSistemaBloqueiaAContinuidade();
    }

    public void validarErroAoPreencherCampoPostalCodeComLetras() throws Exception {
        authAndCheckout.realizarLogin();
        authAndCheckout.adicionarItensAoCarrinho();
        Report.logCapture(Status.INFO, "Redirecionado para a tela de Checkout: Your Information");
        yourInformation.firstNameTextField().sendKeys(UserDataDTO.userData().getFirstName());
        yourInformation.lastNameTextField().sendKeys(UserDataDTO.userData().getLastName());
        yourInformation.postalCodeTextField().sendKeys("ASDAFDAASD");
        validarOSistemaBloqueiaAContinuidade();
    }

    private void validarOSistemaBloqueiaAContinuidade() throws Exception {
        boolean isContinueButtonDisplayed = yourInformation.continueCheckoutButton().isDisplayed();
        if (isContinueButtonDisplayed) {
            Report.logCapture(Status.FAIL, "O sistema permitiu a continuidade para finalizar a compra com campos obrigatórios preenchidos de forma inválida. " +
                            "Comportamento esperado: bloquear a continuidade."
            );
            click(yourInformation.continueCheckoutButton());
        } else {
            Report.logCapture(Status.PASS, "O sistema bloqueou corretamente a continuidade da compra ao detectar campos obrigatórios com dados inválidos."
            );
        }
        Assert.assertFalse(isContinueButtonDisplayed, "O botão de continuidade não deveria estar visível para campos inválidos."
        );
    }
}