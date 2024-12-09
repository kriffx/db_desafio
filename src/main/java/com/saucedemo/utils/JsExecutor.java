package com.saucedemo.utils;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class JsExecutor {

    public static void highlight(WebDriver driver, WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].setAttribute('style', 'background: white; border: 2px solid red;');", element);
    }

    public boolean imagePresent(WebDriver driver, WebElement locator) {
        Object result = ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].complete && " +
                        "typeof arguments[0].naturalWidth != \"undefined\" && " +
                        "arguments[0].naturalWidth > 0", locator);
        boolean loaded = false;
        if (result instanceof Boolean) {
            loaded = (boolean) result;
        }
        return loaded;
    }

    public static void pageLoadTime(WebDriver driver) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        Long loadEventEnd = (Long) jse.executeScript("return window.performance.timing.loadEventEnd;");
        Long navigationStart = (Long) jse.executeScript("return window.performance.timing.navigationStart;");
        long loadTime = loadEventEnd - navigationStart;
        Report.logCapture(Status.INFO, "Tempo de carregamento da página: " + loadTime + "ms");
        long timeLimit = 3000;
        Assert.assertTrue(loadTime <= timeLimit, "O tempo de carregamento excedeu o limite esperado. Tempo: " + loadTime + "ms");
    }
}