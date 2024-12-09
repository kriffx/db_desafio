package com.saucedemo.steps;

import com.aventstack.extentreports.Status;
import com.saucedemo.dto.UserDataDTO;
import com.saucedemo.pageobjects.AuthLoginPage;
import com.saucedemo.utils.Report;
import org.openqa.selenium.WebDriver;

import static com.saucedemo.utils.JsExecutor.*;
import static com.saucedemo.widgets.Element.*;

public class PerformanceUserStep {
    private final WebDriver driver;
    private final AuthLoginPage login;

    public PerformanceUserStep (WebDriver _driver) {
        driver = _driver;
        login = new AuthLoginPage(_driver);
    }

    public void validarLoginETempoDeCarregamento() throws Exception {
        Report.logCapture(Status.INFO, "Tela de login");
        login.usernameTextField().sendKeys(UserDataDTO.userData().getPerformanceUser());
        login.passwordTextField().sendKeys(UserDataDTO.userData().getPassword());
        click(login.loginButton());
        pageLoadTime(driver);
    }
}