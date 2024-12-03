package com.saucedemo.steps;

import com.aventstack.extentreports.Status;
import com.saucedemo.dto.UserDataDTO;
import com.saucedemo.pageobjects.AutenticacaoLoginPage;
import com.saucedemo.utils.Report;
import com.saucedemo.widgets.Element;
import org.openqa.selenium.WebDriver;

import static com.saucedemo.widgets.Element.*;

public class LoginNegativoStep {
    private final AutenticacaoLoginPage loginPage;

    public LoginNegativoStep(WebDriver driver) {
        loginPage = new AutenticacaoLoginPage(driver);
    }

    public void loginComUserNameInvalido() throws Exception {
        Report.logCapture(Status.INFO, "Tela de Login");
        loginPage.usernameTextField().sendKeys("test_01");
        loginPage.passwordTextField().sendKeys(UserDataDTO.userData().getPassword());
        click(loginPage.loginButton());
        assertEquals(loginPage.obterMensagemDeErrorLabel(), "Epic sadface: Username and password do not match any user in this service");
        Report.logCapture(Status.INFO, "obter a mensagem de erro");
    }

    public void loginComPasswordInvalido() throws Exception {
        Report.logCapture(Status.INFO, "Tela de Login");
        loginPage.usernameTextField().sendKeys(UserDataDTO.userData().getUsername());
        loginPage.passwordTextField().sendKeys("1234");
        click(loginPage.loginButton());
        assertEquals(loginPage.obterMensagemDeErrorLabel(), "Epic sadface: Username and password do not match any user in this service");
    }

    public void loginSemSenha() throws Exception {
        Report.logCapture(Status.INFO, "Tela de Login");
        loginPage.usernameTextField().sendKeys(UserDataDTO.userData().getUsername());
        click(loginPage.loginButton());
        assertEquals(loginPage.obterMensagemDeErrorLabel(), "Epic sadface: Password is required");
    }
}