package com.saucedemo.steps;

import com.aventstack.extentreports.Status;
import com.github.javafaker.Faker;
import com.saucedemo.dto.UserDataDTO;
import com.saucedemo.pageobjects.CheckoutYourInformationPage;
import com.saucedemo.support.AutenticacaoECheckout;
import com.saucedemo.utils.Report;
import org.openqa.selenium.WebDriver;

import static com.saucedemo.widgets.Element.*;

public class CheckoutNegativoStep {
    private final AutenticacaoECheckout autenticacaoECheckout;
    private final CheckoutYourInformationPage yourInformation;

    public CheckoutNegativoStep(WebDriver driver) {
        autenticacaoECheckout = new AutenticacaoECheckout(driver);
        yourInformation = new CheckoutYourInformationPage(driver);
    }

    public void validarErroAoNaoPreencherCamposObrigatorios() throws Exception {
        autenticacaoECheckout.getAutenticacaoLogin();
        autenticacaoECheckout.getItensNoCarrinhoECheckout();
        Report.logCapture(Status.INFO, "Redirecionado para a tela de Checkout: Your Information");
        click(yourInformation.continueCheckoutButton());
        assertEquals(yourInformation.mensagemDeErroCamposObrigatoriosLabel(), "Error: First Name is required");
        Report.logCapture(Status.INFO, "obter a mensagem de erro");
    }

    public void validarErroAoPreencherSomenteCampoFirstName() throws Exception {
        autenticacaoECheckout.getAutenticacaoLogin();
        autenticacaoECheckout.getItensNoCarrinhoECheckout();
        Report.logCapture(Status.INFO, "Redirecionado para a tela de Checkout: Your Information");
        yourInformation.firstNameTextField().sendKeys(UserDataDTO.userData().getFirstName());
        click(yourInformation.continueCheckoutButton());
        assertEquals(yourInformation.mensagemDeErroCamposObrigatoriosLabel(), "Error: Last Name is required");
        Report.logCapture(Status.INFO, "obter a mensagem de erro");
    }

    public void validarErroAoPreencherSomenteCampoLastName() throws Exception {
        autenticacaoECheckout.getAutenticacaoLogin();
        autenticacaoECheckout.getItensNoCarrinhoECheckout();
        Report.logCapture(Status.INFO, "Redirecionado para a tela de Checkout: Your Information");
        yourInformation.lastNameTextField().sendKeys(UserDataDTO.userData().getLastName());
        click(yourInformation.continueCheckoutButton());
        assertEquals(yourInformation.mensagemDeErroCamposObrigatoriosLabel(), "Error: First Name is required");
        Report.logCapture(Status.INFO, "obter a mensagem de erro");
    }

    public void validarErroAoPreencherSomenteCampoPostalCode() throws Exception {
        autenticacaoECheckout.getAutenticacaoLogin();
        autenticacaoECheckout.getItensNoCarrinhoECheckout();
        Report.logCapture(Status.INFO, "Redirecionado para a tela de Checkout: Your Information");
        yourInformation.lastNameTextField().sendKeys(UserDataDTO.userData().getLastName());
        click(yourInformation.continueCheckoutButton());
        assertEquals(yourInformation.mensagemDeErroCamposObrigatoriosLabel(), "Error: First Name is required");
        Report.logCapture(Status.INFO, "obter a mensagem de erro");
    }

    public void validarErroAoPreencherOsCamposMaximoDoisCaracteres() throws Exception {
        autenticacaoECheckout.getAutenticacaoLogin();
        autenticacaoECheckout.getItensNoCarrinhoECheckout();
        Report.logCapture(Status.INFO, "Redirecionado para a tela de Checkout: Your Information");
        yourInformation.firstNameTextField().sendKeys("Ri");
        yourInformation.lastNameTextField().sendKeys("Co");
        yourInformation.postalCodeTextField().sendKeys("90");
        validarOSistemaBloqueiaAContinuidade();
    }

    public void validarErroAoPreencherCamposComExcessoDeCaracteres() throws Exception {
        autenticacaoECheckout.getAutenticacaoLogin();
        autenticacaoECheckout.getItensNoCarrinhoECheckout();
        Report.logCapture(Status.INFO, "Redirecionado para a tela de Checkout: Your Information");
        yourInformation.firstNameTextField().sendKeys(Faker.instance().lorem().characters(300));
        yourInformation.lastNameTextField().sendKeys(Faker.instance().lorem().characters(300));
        yourInformation.postalCodeTextField().sendKeys(Faker.instance().lorem().characters(300));
        validarOSistemaBloqueiaAContinuidade();
    }

    public void validarErroAoPreencherCamposComNumeroECaracteresEspeciais() throws Exception {
        autenticacaoECheckout.getAutenticacaoLogin();
        autenticacaoECheckout.getItensNoCarrinhoECheckout();
        Report.logCapture(Status.INFO, "Redirecionado para a tela de Checkout: Your Information");
        yourInformation.firstNameTextField().sendKeys("Ric@rd0!");
        yourInformation.lastNameTextField().sendKeys("C0st@123");
        yourInformation.postalCodeTextField().sendKeys("#90619@90");
        validarOSistemaBloqueiaAContinuidade();
    }

    public void validarErroAoPreencherCampoPostalCodeComLetras() throws Exception {
        autenticacaoECheckout.getAutenticacaoLogin();
        autenticacaoECheckout.getItensNoCarrinhoECheckout();
        Report.logCapture(Status.INFO, "Redirecionado para a tela de Checkout: Your Information");
        yourInformation.firstNameTextField().sendKeys(UserDataDTO.userData().getFirstName());
        yourInformation.lastNameTextField().sendKeys(UserDataDTO.userData().getLastName());
        yourInformation.postalCodeTextField().sendKeys("ASDAFDAASD");
        validarOSistemaBloqueiaAContinuidade();
    }

    private void validarOSistemaBloqueiaAContinuidade() throws Exception {
        if (yourInformation.continueCheckoutButton().isEnabled()) {
            Report.logCapture(Status.INFO, "Os campos ja foram preenchidos");
            click(yourInformation.continueCheckoutButton());
            Report.logCapture(Status.FAIL,
                    "O sistema permitiu o preenchimento dos campos obrigatórios com dados invalidos e prosseguiu para a finalização da compra. " +
                            "Comportamento esperado: bloquear a continuidade para finalizar a compra."
            );
        } else {
            Report.logCapture(Status.PASS,
                    "O sistema corretamente bloqueou a continuidade para finalizar a compra ao detectar campos com apenas dois caracteres."
            );
        }
    }
}