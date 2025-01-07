package com.saucedemo.webdrivers;

import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Setter;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    @Setter
    private static ExtentTest test;

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
                    throw new IllegalArgumentException("Navegador inválido:" + browser);
            }
        } catch (SessionNotCreatedException e) {
            throw new SessionNotCreatedException("Sessão não criada, versão de driver não suportada.", e);
        } catch (WebDriverException e) {
            throw new WebDriverException("Não foi possível encontrar o binário do driver.", e);
        }
    }
}