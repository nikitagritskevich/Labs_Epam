package com.epam.lab;

public class FibonacciNumber {

  public static void main(String[] args) {
    int n = 5;
    System.out.print(getFibonacciNumber(0));
    for (int i = 0; i < n; i++) {
      System.out.print(", " + getFibonacciNumber(i));
    }
  }

  public static int getFibonacciNumber(int n) {
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    return getFibonacciNumber(n - 1) + getFibonacciNumber(n - 2);
  }

}
