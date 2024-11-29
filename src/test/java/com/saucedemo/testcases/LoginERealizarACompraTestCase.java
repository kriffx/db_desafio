package com.saucedemo.testcases;

import com.saucedemo.utils.BaseTest;
import com.saucedemo.webdrivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginERealizarACompraTestCase extends BaseTest {

    private WebDriver driver() {
        return DriverManager.getDriver();
    }


    @Test(
            description = "Efeturar login e finalizar a compra.",
            groups = {"positivo"}
    )
    public void finalizarACompraComSucessoTest() {

    }
}