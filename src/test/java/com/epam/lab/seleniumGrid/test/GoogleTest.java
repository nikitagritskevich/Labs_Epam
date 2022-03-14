package com.epam.lab.seleniumGrid.test;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {

  private WebDriver driver;
  private final String URL = "http://169.254.45.134:4444/";

  @BeforeMethod
  public void initBrowser() throws MalformedURLException {
    driver = new RemoteWebDriver(new URL(URL), new EdgeOptions());
  }

  @Test
  public void googleOpenTest() {
    driver.get("https://www.google.com/");
    Assert.assertEquals(driver.getTitle(),"Google");
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() {
    driver.quit();
  }
}
