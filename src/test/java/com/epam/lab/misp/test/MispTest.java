package com.epam.lab.misp.test;

import com.epam.lab.misp.page.AuthorizationPage;
import com.epam.lab.misp.page.SectionEditPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MispTest {

  private SectionEditPage sectionPage;

  @BeforeClass(alwaysRun = true)
  public void createRandomSection() {
    sectionPage = new AuthorizationPage().openPage().logInAsAdmin().navigateToRandomSection();
  }

  @Test(description = "Checking navigation button is active")
  public void activeNavigationButtonTest() {
    Assert.assertTrue(sectionPage.isNavigateButtonActive(), "The navigate button isn't active");
  }

  @Test(description = "Checking navigate button color is white")
  public void checkWhiteColorNavigationButtonTest() {
    Assert.assertTrue(sectionPage.isNavigateButtonWhite(), "The navigate button isn't white color");
  }

}
