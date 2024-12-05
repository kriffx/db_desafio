package com.saucedemo.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JsExecutor {
    public static void highlight(WebDriver driver, WebElement locator) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].classList.add('highlight');", locator);
    }

    public static void injectHighlightStyle(WebDriver driver) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(
                "if (!document.getElementById('highlight-style')) {" +
                        "  var style = document.createElement('style');" +
                        "  style.id = 'highlight-style';" +
                        "  style.innerHTML = '.highlight { background: white; border: 2px solid red; }';" +
                        "  document.head.appendChild(style);" +
                        "}");
    }

    public static void highlightElementWithJs(WebDriver driver, WebElement locator) {
        JsExecutor.injectHighlightStyle(driver);
        JsExecutor.highlight(driver, locator);
    }
}