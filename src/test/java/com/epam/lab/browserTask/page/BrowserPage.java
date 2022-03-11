package com.epam.lab.browserTask.page;

import com.epam.lab.browserTask.service.TestDataReader;
import org.openqa.selenium.WebDriver;

public class BrowserPage {
  private WebDriver driver;

  public BrowserPage(WebDriver driver) {
    this.driver = driver;
  }

  public BrowserPage openPage(){
    driver.get(TestDataReader.getBrowserUrl());
    return this;
  }

  public String getCurrentURL(){
    return driver.getCurrentUrl();
  }
}
