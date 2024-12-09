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

    public static void verificarTempoDeCarregamento(WebDriver driver, long timeLimitMs) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        long loadEventEnd = (long) jsExecutor.executeScript("return window.performance.timing.loadEventEnd;");
        long navigationStart = (long) jsExecutor.executeScript("return window.performance.timing.navigationStart;");
        if (loadEventEnd == 0) {
            Report.logCapture(Status.FAIL, "A página ainda não terminou de carregar ou 'loadEventEnd' não está acessível.");
            throw new IllegalStateException("'loadEventEnd' é zero. Não foi possível calcular o tempo de carregamento.");
        }
        long loadTime = loadEventEnd - navigationStart;
        Report.logCapture(Status.INFO, "Tempo de carregamento da página: " + loadTime + "ms");
        if (loadTime > timeLimitMs) {
            String mensagemErro = String.format(
                    "Tempo de carregamento excedeu o limite. Tempo: %dms, Limite: %dms",
                    loadTime, timeLimitMs
            );
            Report.logCapture(Status.FAIL, mensagemErro);
            throw new AssertionError(mensagemErro);
        }
        Report.logCapture(Status.PASS, "O tempo de carregamento da página está dentro do limite esperado.");
    }

}