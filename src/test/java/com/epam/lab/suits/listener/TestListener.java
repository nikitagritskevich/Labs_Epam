package com.epam.lab.suits.listener;

import java.lang.reflect.Method;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

  private final Logger logger = LogManager.getRootLogger();

  @Override
  public void onTestStart(ITestResult iTestResult) {
    logger.info(iTestResult.getTestClass().getName());
    Method currentMethod = iTestResult.getMethod().getConstructorOrMethod().getMethod();
    if (currentMethod.getName() == "test1" || currentMethod.getName() == "test7") {
      logger.warn("That is reflection method and go ahead");
    }
  }

  @Override
  public void onTestSuccess(ITestResult iTestResult) {

  }

  @Override
  public void onTestFailure(ITestResult iTestResult) {
    logger.info(iTestResult.getName() + " - this test is failure ");
  }

  @Override
  public void onTestSkipped(ITestResult iTestResult) {

  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

  }

  @Override
  public void onStart(ITestContext iTestContext) {

  }

  @Override
  public void onFinish(ITestContext iTestContext) {

  }
}
