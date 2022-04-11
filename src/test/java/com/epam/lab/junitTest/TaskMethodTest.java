package com.epam.lab.junitTest;

import com.epam.lab.TaskMethod;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

public class TaskMethodTest {

  private static List<String> testData;

  @BeforeClass
  public static void initTestList(){
    testData = TaskMethod.getListTaskString();;
  }

  @Test
  public void checkNumberMultiplyOfThreeTest() {
    Assert.assertEquals(testData.get(2),"Fizz");
  }

  @Test
  public void checkNumberMultiplyOfFifeTest(){
    Assert.assertEquals(testData.get(4),"Buzz");
  }

  @Test
  public void checkNumberMultiplyOfFifteen(){
    Assert.assertEquals(testData.get(14),"FizzBuzz");
  }
}