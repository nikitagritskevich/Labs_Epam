package com.epam.lab.misp.page;

import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.util.List;
import java.util.Random;

public class MispMainPage {

  public SectionEditPage selectRandomSection() {
    List<SelenideElement> tableElements = $x("//tbody[@class='MuiTableBody-root']").shouldBe(
        Condition.visible).$$("tr");
    SelenideElement randomSection = tableElements.get(
        new Random().nextInt(tableElements.size() - 1)).scrollTo();
    randomSection.click();
    return new SectionEditPage();
  }

}
