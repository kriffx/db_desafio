package com.saucedemo.testcases;

import com.saucedemo.utils.BaseTest;
import com.saucedemo.webdrivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginERealizacaoCompraTestCase extends BaseTest {

    private WebDriver driver() {
        return DriverManager.getDriver();
    }


    @Test(
            description = "Efeturar login e realizar compra.",
            groups = {"positivo"}
    )
    public void test() {

    }
}