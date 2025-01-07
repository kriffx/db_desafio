package com.saucedemo.webdrivers;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private static ExtentTest test;

    public static void setTest(ExtentTest extentTest) {
        test = extentTest;
    }

    public static WebDriver createInstance(BrowserEnum browser) {
        try {
            switch (browser) {
                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    return new FirefoxDriver();
                case CHROME:
                    WebDriverManager.chromedriver().setup();
                    return new ChromeDriver();
                case EDGE:
                    WebDriverManager.edgedriver().setup();
                    return new EdgeDriver();
                default:
                    String message = "DriverFactory.getInstance() recebeu um argumento invalido";
                    if (test != null) {
                        test.log(Status.FAIL, message);
                    }
                    throw new IllegalArgumentException(message);
            }
        } catch (SessionNotCreatedException e) {
            String message = "Sessao nao criada, versao do driver nao suportada.";
            if (test != null) {
                test.log(Status.FAIL, message);
            }
            throw new SessionNotCreatedException(message, e);
        } catch (WebDriverException e) {
            String message = "Nao foi possivel encontrar o binario do driver.";
            if (test != null) {
                test.log(Status.FAIL, message);
            }
            throw new WebDriverException(message, e);
        }
    }
}