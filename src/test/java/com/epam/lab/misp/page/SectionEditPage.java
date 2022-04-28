package com.epam.lab.misp.page;

import static com.codeborne.selenide.Selenide.$x;

import org.openqa.selenium.support.Color;

public class SectionEditPage {

  private final String XPATH_NAVIGATE_BUTTON = "//button[@data-test=\"open-navigation-btn\"]";

  public boolean isNavigateButtonActive() {
    return $x(XPATH_NAVIGATE_BUTTON).isEnabled();
  }

  public boolean isNavigateButtonWhite() {
    Color navigateButtonColor = Color.fromString($x(XPATH_NAVIGATE_BUTTON).getCssValue("color"));
    return Color.fromString("white").equals(navigateButtonColor);
  }

}
