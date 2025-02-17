package com.saucedemo.widgets;

import com.aventstack.extentreports.Status;
import com.saucedemo.utils.Report;
import org.openqa.selenium.*;
import org.testng.Assert;

public class Element {

       public static void click(WebElement locator) throws Exception {
        try {
            if (locator.isDisplayed()) {
                locator.click();
                Report.log(Status.PASS, "O botão " + locator + " recebeu um clique.");
            } else {
                Report.logCapture(Status.FAIL, "O botão " + locator + " não recebeu um clique.");
            }
        } catch (InvalidElementStateException | NoSuchElementException | StaleElementReferenceException |
                 TimeoutException e) {
            throw new Exception(e);
        }
    }

    public static void assertEquals(WebElement locator, String expected, String message) throws Exception {
        try {
            Assert.assertEquals(locator.getText(), expected, message);
        } catch (InvalidElementStateException | NoSuchElementException | StaleElementReferenceException |
                 TimeoutException e) {
            throw new Exception(e);
        }
    }
}