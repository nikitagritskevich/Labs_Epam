package com.epam.lab;

public class FibonacciNumber {

  public static void main(String[] args) {
    int n = 5;
    String result = "";
    for (int i = 0; i < n; i++) {
      result += fibonacciNumber(i) + ", ";
    }
    System.out.println(result.substring(0, result.length() - 2));
  }

  public static int fibonacciNumber(int n) {
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    return fibonacciNumber(n - 1) + fibonacciNumber(n - 2);
  }
}
