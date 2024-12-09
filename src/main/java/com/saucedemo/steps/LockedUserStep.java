package com.saucedemo.steps;

import com.aventstack.extentreports.Status;
import com.saucedemo.dto.UserDataDTO;
import com.saucedemo.pageobjects.AuthLoginPage;
import com.saucedemo.utils.Report;
import org.openqa.selenium.WebDriver;

import static com.saucedemo.widgets.Element.*;

public class LockedUserStep {
    private final AuthLoginPage login;

    public LockedUserStep (WebDriver driver) {
        login = new AuthLoginPage(driver);
    }

    public void validarMensagemDeErroParaUsuarioBloqueado() throws Exception {
        Report.logCapture(Status.INFO, "Tela de login");
        login.usernameTextField().sendKeys(UserDataDTO.userData().getLockedUser());
        login.passwordTextField().sendKeys(UserDataDTO.userData().getPassword());
        click(login.loginButton());
        assertEquals(login.obterMensagemDeErrorLabel(), "Epic sadface: Sorry, this user has been locked out.");
    }
}