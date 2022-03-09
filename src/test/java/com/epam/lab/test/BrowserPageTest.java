package com.epam.lab.test;

import com.epam.lab.page.BrowserPage;
import com.epam.lab.service.DriverManager;
import com.epam.lab.service.TestDataReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserPageTest {

  private WebDriver driver;

  @BeforeMethod
  public void initializationWebDriver() {
    driver = DriverManager.getDriver();
  }

  @Test
  public void checkingPageBrowser() {
    String environmentBrowserURL = TestDataReader.getBrowserUrl();
    String browserURL = new BrowserPage(driver).openPage().getCurrentURL();
    Assert.assertEquals(environmentBrowserURL, browserURL, "Ops, that url isn't equals");
  }

  @AfterMethod(alwaysRun = true)
  public void tearDawn() {
    driver.quit();
    DriverManager.tearDawn();
  }
}
