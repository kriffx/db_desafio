package com.saucedemo.testcases;

import com.saucedemo.steps.LoginNegativoStep;
import com.saucedemo.utils.BaseTest;
import com.saucedemo.webdrivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginNegativoTestCase extends BaseTest {
    private WebDriver driver() {
        return DriverManager.getDriver();
    }

    @Test(
            description = "CT-002, Tentar login com username inválido.",
            groups = {"web"}
    )
    public void loginComUserNameInvalidoTest() throws Exception {
        LoginNegativoStep loginNegativoStep = new LoginNegativoStep(driver());
        loginNegativoStep.loginComUserNameInvalido();
    }

    @Test(
            description = "CT-003, Tentar login com password inválido.",
            groups = {"web"}
    )
    public void loginComPasswordInvalidoTest() throws Exception {
        LoginNegativoStep loginNegativoStep = new LoginNegativoStep(driver());
        loginNegativoStep.loginComPasswordInvalido();
    }

    @Test(
            description = "CT-004, Tentar login sem preencher a senha.",
            groups = {"web"}
    )
    public void loginSemPreencherASenhaTest() throws Exception {
        LoginNegativoStep loginNegativoStep = new LoginNegativoStep(driver());
        loginNegativoStep.loginSemSenha();
    }

    @Test(
            description = "CT-005, Tentar login sem preencher o username.",
            groups = {"web"}
    )
    public void loginSemPreencherOUsernameTest() throws Exception {
        LoginNegativoStep loginNegativoStep = new LoginNegativoStep(driver());
        loginNegativoStep.loginSemUsername();
    }

    @Test(
            description = "CT-006, Tentar login sem preencher o username e senha.",
            groups = {"web"}
    )
    public void loginSemPreencherOUsernameEAPasswordTest() throws Exception {
        LoginNegativoStep loginNegativoStep = new LoginNegativoStep(driver());
        loginNegativoStep.loginSemUsernameEAPassword();
    }

    @Test(
            description = "CT-007, Tentar login com username e senha inválidos.",
            groups = {"web"}
    )
    public void loginComOUsernameEAPasswordInvalidosTest() throws Exception {
        LoginNegativoStep loginNegativoStep = new LoginNegativoStep(driver());
        loginNegativoStep.loginComUsernameEAPasswordInvalidos();
    }

    @Test(
            description = "CT-008, Tentar login com username e senha mais de 255 caracteres.",
            groups = {"web"}
    )
    public void loginComOUsernameEAPassword255CaracteresTest() throws Exception {
        LoginNegativoStep loginNegativoStep = new LoginNegativoStep(driver());
        loginNegativoStep.loginComUsernameEAPasswordMaisDe255Caracteres();
    }

    @Test(
            description = "CT-009, Tentar login com username e senha de 3 caracteres.",
            groups = {"web"}
    )
    public void loginComOUsernameEAPassword3CaracteresTest() throws Exception {
        LoginNegativoStep loginNegativoStep = new LoginNegativoStep(driver());
        loginNegativoStep.loginComUsernameEAPasswordMaximoDe3Caracteres();
    }
}