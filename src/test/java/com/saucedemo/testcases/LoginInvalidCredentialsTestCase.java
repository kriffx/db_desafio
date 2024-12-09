package com.saucedemo.testcases;

import com.saucedemo.steps.LoginNegativeStep;
import com.saucedemo.utils.BaseTest;
import com.saucedemo.webdrivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginInvalidCredentialsTestCase extends BaseTest {
    private WebDriver driver() {
        return DriverManager.getDriver();
    }

    @Test(
            description = "CT-002, Tentar login com username inválido.",
            groups = {"web"}
    )
    public void loginComUserNameInvalidoTest() throws Exception {
        LoginNegativeStep loginNegativeStep = new LoginNegativeStep(driver());
        loginNegativeStep.loginComUserNameInvalido();
    }

    @Test(
            description = "CT-003, Tentar login com password inválido.",
            groups = {"web"}
    )
    public void loginComPasswordInvalidoTest() throws Exception {
        LoginNegativeStep loginNegativeStep = new LoginNegativeStep(driver());
        loginNegativeStep.loginComPasswordInvalido();
    }

    @Test(
            description = "CT-004, Tentar login sem preencher a senha.",
            groups = {"web"}
    )
    public void loginSemPreencherASenhaTest() throws Exception {
        LoginNegativeStep loginNegativeStep = new LoginNegativeStep(driver());
        loginNegativeStep.loginSemSenha();
    }

    @Test(
            description = "CT-005, Tentar login sem preencher o username.",
            groups = {"web"}
    )
    public void loginSemPreencherOUsernameTest() throws Exception {
        LoginNegativeStep loginNegativeStep = new LoginNegativeStep(driver());
        loginNegativeStep.loginSemUsername();
    }

    @Test(
            description = "CT-006, Tentar login sem preencher o username e senha.",
            groups = {"web"}
    )
    public void loginSemPreencherOUsernameEAPasswordTest() throws Exception {
        LoginNegativeStep loginNegativeStep = new LoginNegativeStep(driver());
        loginNegativeStep.loginSemUsernameEAPassword();
    }

    @Test(
            description = "CT-007, Tentar login com username e senha inválidos.",
            groups = {"web"}
    )
    public void loginComOUsernameEAPasswordInvalidosTest() throws Exception {
        LoginNegativeStep loginNegativeStep = new LoginNegativeStep(driver());
        loginNegativeStep.loginComUsernameEAPasswordInvalidos();
    }

    @Test(
            description = "CT-008, Tentar login com username e senha mais de 255 caracteres.",
            groups = {"web"}
    )
    public void loginComOUsernameEAPassword255CaracteresTest() throws Exception {
        LoginNegativeStep loginNegativeStep = new LoginNegativeStep(driver());
        loginNegativeStep.loginComUsernameEAPasswordMaisDe255Caracteres();
    }

    @Test(
            description = "CT-009, Tentar login com username e senha de 3 caracteres.",
            groups = {"web"}
    )
    public void loginComOUsernameEAPassword3CaracteresTest() throws Exception {
        LoginNegativeStep loginNegativeStep = new LoginNegativeStep(driver());
        loginNegativeStep.loginComUsernameEAPasswordMaximoDe3Caracteres();
    }

    @Test(
            description = "CT-010, Tentar login com username e senha de 3 caracteres.",
            groups = {"web"}
    )
    public void loginComOUsernameEAPasswordComCaracteresEspeciaisTest() throws Exception {
        LoginNegativeStep loginNegativeStep = new LoginNegativeStep(driver());
        loginNegativeStep.loginComUsernameEAPasswordComCaracteresEspeciais();
    }
}