package com.saucedemo.steps;

import com.aventstack.extentreports.Status;
import com.saucedemo.dto.UserDataDTO;
import com.saucedemo.dto.UserModelDTO;
import com.saucedemo.pageobjects.LoginAppObject;
import com.saucedemo.utils.Report;
import org.openqa.selenium.WebDriver;

public class LoginERealizarACompraStep {
    private WebDriver driver;
    private final LoginAppObject loginUsuario;

    public LoginERealizarACompraStep(WebDriver _driver) {
        driver = _driver;
        loginUsuario = new LoginAppObject(_driver);
    }

    public void EfeturaLoginEFInalizarCompra() {
        EfeturaLogin();
    }

    private void EfeturaLogin() {
        Report.log(Status.INFO,"Acessar na tela de login");
        loginUsuario.usernameTextField().sendKeys(UserDataDTO.userData().getUsername());
        loginUsuario.passwordTextField().sendKeys("test");
        if(loginUsuario.loginButton().isDisplayed()) {
            loginUsuario.loginButton().click();
            Report.log(Status.PASS, "O botão 'Login' recebeu um clique.");
        } else {
            Report.logCapture(Status.FAIL, "O botão 'Login' não recebeu um clique");
        }
    }
}