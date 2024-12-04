package com.saucedemo.steps;

import com.aventstack.extentreports.Status;
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
        Report.logCapture(Status.INFO, "Redirecionado tela de Checkout: Your Information");
        autenticacaoECheckout.getAutenticacaoLogin();
        autenticacaoECheckout.getItensNoCarrinhoECheckout();
        click(yourInformation.continueCheckoutButton());
        assertEquals(yourInformation.mensagemDeErroCamposObrigatoriosLabel(), "Error: First Name is required");
    }
}