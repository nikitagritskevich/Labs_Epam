package com.epam.lab.misp.test;

import com.epam.lab.misp.page.AuthorizationPage;
import com.epam.lab.misp.page.MispMainPage;
import com.epam.lab.misp.page.SectionEditPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MispTest {

  @Test(description = "opening any section and check this")
  public void correctOpenSection() {
    SoftAssert asserts = new SoftAssert();
    MispMainPage mainPage = new AuthorizationPage().openPage().adminAuthorization();
    asserts.assertTrue(mainPage.getTitle().equalsIgnoreCase("EMF Sections"), "Title wasn't equals");
    SectionEditPage editPage = mainPage.selectRandomSection();
    editPage.assertOpenPageOrNot();
    asserts.assertTrue(editPage.isNavigateButtonActivity(), "The navigate button isn't active");
    asserts.assertTrue(editPage.isNavigateButtonWhite(), "The navigate button isn't white color");
    asserts.assertAll();
  }

}
