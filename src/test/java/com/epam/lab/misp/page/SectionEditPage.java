package com.epam.lab.misp.page;

import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.support.Color;
import org.testng.Assert;

public class SectionEditPage {

  private final String XPATH_NAVIGATE_BUTTON = "//button[@data-test=\"open-navigation-btn\"]";

  public void assertOpenPageOrNot() {
    try {
      $x(XPATH_NAVIGATE_BUTTON).shouldBe(Condition.visible);
    } catch (AssertionError e) {
      Assert.fail("Ops, this page wasn't open");
    }
  }

  public boolean isNavigateButtonActivity() {
    return $x(XPATH_NAVIGATE_BUTTON).isEnabled();
  }

  public boolean isNavigateButtonWhite() {
    Color navigateButtonColor = Color.fromString($x(XPATH_NAVIGATE_BUTTON).getCssValue("color"));
    return Color.fromString("white").equals(navigateButtonColor);
  }

}
