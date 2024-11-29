package com.saucedemo.utils;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import com.saucedemo.webdrivers.BrowserEnum;
import com.saucedemo.webdrivers.DriverFactory;
import com.saucedemo.webdrivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

@Listeners({ExtentITestListenerClassAdapter.class, Report.class})
public class BaseTest {

    @BeforeTest
    public void setUp() {
        WebDriver driver = DriverFactory.createInstance(BrowserEnum.CHROME);
        DriverManager.setDriver(driver);
        driver.manage().window().maximize();
        driver.get(Property.get("url"));
    }

    @AfterTest
    public void tearDown() {
        DriverManager.quitDriver();
    }
}