package com.saucedemo.webdrivers;

import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Setter;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {
    static boolean isHeadless;

    public static WebDriver createInstance(BrowserEnum browser) {

        String headless = System.getProperty("headless", "false").toLowerCase();
        if (headless.equals("true") || headless.equals("false")) {
            isHeadless = Boolean.parseBoolean(headless);
        } else {
            throw new IllegalArgumentException("The headless argument only receives true or false!");
        }

        try {
            switch (browser) {
                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    if (isHeadless) {
                        firefoxOptions.addArguments("--headless");
                    }
                    return new FirefoxDriver();
                case CHROME:
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    if (isHeadless) {
                        chromeOptions.addArguments("--headless");
                    }
                    return new ChromeDriver();
                case EDGE:
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions edgeOptions = new EdgeOptions();
                    if (isHeadless) {
                        edgeOptions.addArguments("--headless");
                    }
                    return new EdgeDriver();
                default:
                    throw new IllegalArgumentException("Navegador inválido:" + browser);
            }
        } catch (SessionNotCreatedException e) {
            throw new SessionNotCreatedException("Sessão não criada, versão de driver não suportada.", e);
        } catch (WebDriverException e) {
            throw new WebDriverException("Não foi possível encontrar o binário do driver.", e);
        }
    }
}