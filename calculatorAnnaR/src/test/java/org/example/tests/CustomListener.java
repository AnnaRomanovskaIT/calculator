package org.example.tests;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener implements ITestListener {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    private long startTime;

    @Override
    public void onTestStart(ITestResult result) {
        startTime = System.currentTimeMillis();
        System.out.println(ANSI_GREEN+"Test started: "+ANSI_RESET);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println(ANSI_GREEN+"Test passed: " + result.getMethod().getMethodName()+ ANSI_RESET);
        System.out.println("Duration: " + ANSI_GREEN + duration + " ms" + ANSI_RESET);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println(ANSI_RED + "Test failed: " + result.getMethod().getMethodName()+ ANSI_RESET);
        System.out.println("Duration: " + ANSI_RED + duration + " ms"+ ANSI_RESET);
        System.out.println("Exception: " + ANSI_RED + result.getThrowable() + ANSI_RESET);
    }
}
