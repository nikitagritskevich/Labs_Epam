package com.epam.lab.service;

import java.util.ResourceBundle;

public class TestDataReader {
  private static final ResourceBundle bundle = ResourceBundle.getBundle(System.getProperty("env","qa"));
  private static final String TEST_BROWSER_URL = "test.browser.url";
  public static String getBrowserUrl(){
    return bundle.getString(TEST_BROWSER_URL);
  }

}
