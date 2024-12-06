package com.saucedemo.steps;

import com.aventstack.extentreports.Status;
import com.github.javafaker.Faker;
import com.saucedemo.dto.UserDataDTO;
import com.saucedemo.pageobjects.AuthLoginPage;
import com.saucedemo.utils.Report;
import org.openqa.selenium.WebDriver;

import static com.saucedemo.widgets.Element.*;

public class LoginNegativoStep {
    private final AuthLoginPage loginPage;

    public LoginNegativoStep(WebDriver driver) {
        loginPage = new AuthLoginPage(driver);
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
        Report.logCapture(Status.INFO, "obter a mensagem de erro");
    }

    public void loginSemSenha() throws Exception {
        Report.logCapture(Status.INFO, "Tela de Login");
        loginPage.usernameTextField().sendKeys(UserDataDTO.userData().getUsername());
        click(loginPage.loginButton());
        assertEquals(loginPage.obterMensagemDeErrorLabel(), "Epic sadface: Password is required");
        Report.logCapture(Status.INFO, "obter a mensagem de erro");
    }

    public void loginSemUsername() throws Exception {
        Report.logCapture(Status.INFO, "Tela de login");
        loginPage.passwordTextField().sendKeys(UserDataDTO.userData().getPassword());
        click(loginPage.loginButton());
        assertEquals(loginPage.obterMensagemDeErrorLabel(), "Epic sadface: Username is required");
        Report.logCapture(Status.INFO, "obter a mensagem de erro");
    }

    public void loginSemUsernameEAPassword() throws Exception {
        Report.logCapture(Status.INFO, "Tela de login");
        click(loginPage.loginButton());
        assertEquals(loginPage.obterMensagemDeErrorLabel(), "Epic sadface: Username is required");
        Report.logCapture(Status.INFO, "obter a mensagem de erro");
    }

    public void loginComUsernameEAPasswordInvalidos() throws Exception {
        Report.logCapture(Status.INFO, "Tela de login");
        loginPage.usernameTextField().sendKeys("test_01");
        loginPage.passwordTextField().sendKeys("1234");
        click(loginPage.loginButton());
        assertEquals(loginPage.obterMensagemDeErrorLabel(), "Epic sadface: Username and password do not match any user in this service");
        Report.logCapture(Status.INFO, "obter a mensagem de erro");
    }

    public void loginComUsernameEAPasswordMaisDe255Caracteres() throws Exception {
        Report.logCapture(Status.INFO, "Tela de login");
        loginPage.usernameTextField().sendKeys(Faker.instance().lorem().characters(300));
        loginPage.passwordTextField().sendKeys(Faker.instance().lorem().characters(300));
        click(loginPage.loginButton());
        assertEquals(loginPage.obterMensagemDeErrorLabel(), "Epic sadface: Username and password do not match any user in this service");
        Report.logCapture(Status.INFO, "obter a mensagem de erro");
    }

    public void loginComUsernameEAPasswordMaximoDe3Caracteres() throws Exception {
        Report.logCapture(Status.INFO, "Tela de login");
        loginPage.usernameTextField().sendKeys(Faker.instance().lorem().characters(3));
        loginPage.passwordTextField().sendKeys(Faker.instance().lorem().characters(3));
        click(loginPage.loginButton());
        assertEquals(loginPage.obterMensagemDeErrorLabel(), "Epic sadface: Username and password do not match any user in this service");
        Report.logCapture(Status.INFO, "obter a mensagem de erro");
    }
}