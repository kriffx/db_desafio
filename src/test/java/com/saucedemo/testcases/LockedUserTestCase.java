package com.saucedemo.testcases;

import com.saucedemo.steps.LockedUserStep;
import com.saucedemo.utils.BaseTest;
import com.saucedemo.webdrivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LockedUserTestCase extends BaseTest {

    private WebDriver driver() {
        return DriverManager.getDriver();
    }

    @Test(
            description = "CT-001, Valida o bloqueio de login ao tentar autenticar com um usuário bloqueado"
    )
    public void validarBloqueioDeLoginParaUsuarioBloqueadoTest() throws Exception {
        LockedUserStep lockedUserStep = new LockedUserStep(driver());
        lockedUserStep.validarMensagemDeErroParaUsuarioBloqueado();
    }
}