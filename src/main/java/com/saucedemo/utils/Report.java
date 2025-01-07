package com.saucedemo.utils;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.service.ExtentTestManager;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Report implements ITestListener {

    @Override
    public synchronized void onTestStart(ITestResult result) {
        System.out.println("Iniciando o teste: " + result.getName());
        ExtentTestManager.createMethod(result, true);
        System.out.println("Teste criado: " + ExtentTestManager.getTest());
    }

    public void onTestFailure(ITestResult result) {
        ExtentTestManager.getTest().fail("Ocorreu uma falha no teste.", Screenshot.capture());
    }

    public static void log(Status status, String message) {
        ExtentTestManager.getTest().log(status, message);
    }

    public static void logCapture(Status status, String message) {
        ExtentTestManager.getTest().log(status, message, Screenshot.capture());
    }
}