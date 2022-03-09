package com.epam.lab.service;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class DriverManager {

  private static WebDriver driver;

  public static WebDriver getDriver() {
    if (driver == null) {
      switch (System.getProperty("browser", "chrome")) {
        case "chrome": {
          driver = WebDriverManager.chromedriver().create();
          break;
        }
        case "firefox": {
          driver = WebDriverManager.firefoxdriver().create();
          break;
        }
        case "opera": {
          driver = WebDriverManager.operadriver().create();
          break;
        }
        default: {
          driver = WebDriverManager.edgedriver().create();
        }
      }
    }
    driver.manage().window().maximize();
    return driver;
  }

  public static void tearDawn() {
    driver.quit();
    driver = null;
  }

}
