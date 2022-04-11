package com.epam.lab;

import java.util.ArrayList;
import java.util.List;

public class TaskMethod {

  public static List<String> getListTaskString() {
    List<String> result = new ArrayList<>();
    for (int i = 1; i <= 100; i++) {
      if (i % 15 == 0) {
        result.add("FizzBuzz");
        continue;
      }
      if (i % 3 == 0) {
        result.add("Fizz");
        continue;
      }
      if (i % 5 == 0) {
        result.add("Buzz");
        continue;
      }
      result.add(String.valueOf(i));
    }
    return result;
  }

}
