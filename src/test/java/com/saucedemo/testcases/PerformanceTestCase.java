package com.saucedemo.testcases;

import com.saucedemo.steps.PerformanceUserStep;
import com.saucedemo.utils.BaseTest;
import com.saucedemo.webdrivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class PerformanceTestCase extends BaseTest {

    private WebDriver driver() {
        return DriverManager.getDriver();
    }

    @Test(
            description = "CT-001, Verificar a performance do carregamento ao fazer login",
            groups = {"web", "BUG"}
    )
    public void performanceDoCarregamentoTest() throws Exception {
        PerformanceUserStep performanceUserStep = new PerformanceUserStep(driver());
        performanceUserStep.validarLoginETempoDeCarregamento();
    }
}