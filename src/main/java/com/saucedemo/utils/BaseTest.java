package com.saucedemo.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.service.ExtentService;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import com.saucedemo.webdrivers.BrowserEnum;
import com.saucedemo.webdrivers.DriverFactory;
import com.saucedemo.webdrivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Listeners({ExtentITestListenerClassAdapter.class, Report.class})
public class BaseTest {

    protected ExtentReports extentReports;
    protected ExtentTest extentTest;

    @BeforeMethod
    public void setUp() {
        extentReports = ExtentService.getInstance();
        extentTest = extentReports.createTest("O teste esta iniciando.");
        WebDriver driver = DriverFactory.createInstance(BrowserEnum.CHROME);
        DriverManager.setDriver(driver);
        driver.manage().window().maximize();
        driver.get(Property.get("url"));
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}