package com.epam.lab.misp.page;


import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Condition;

public class AuthorizationPage {

  private static final String URL = "https://misp-qa.by2.epm-chrt.projects.epam.com/login";
  private String adminLogin = "auto_misp";
  private String adminPassword = "password";

  public AuthorizationPage openPage() {
    open(URL);
    return this;
  }

  public MispMainPage logInAsAdmin() {
    $x("//input[@name='login']").shouldBe(Condition.visible).setValue(adminLogin);
    $x("//input[@name='password']").setValue(adminPassword);
    $x("//*[@type='submit']").submit();
    return new MispMainPage();
  }


}
