package com.epam.lab;

import java.util.Arrays;
import java.util.List;

public class QuickAndDwarfSort {

  public static void main(String[] args) {
    List<Integer> array = Arrays.asList(2, 12, 123421, -1000, 115, 12, -12, -13, 24, -13);
    quickSort(array, 0, array.size() - 1);
    dwarfSort(array);
    System.out.println(array);
  }

  public static void dwarfSort(List<Integer> array) {
    int index = 1;
    while (index < array.size()) {
      if (index == 0) {
        index++;
      }
      if(array.get(index) <= array.get(index-1)){
        index++;
      }else {
        swap(array,index,index-1);
        index--;
      }
    }
  }

  public static void quickSort(List<Integer> array, int leftBorder, int rightBorder) {
    int leftMark = leftBorder;
    int rightMark = rightBorder;
    int middleMark = (leftMark + rightMark) / 2;
    while (leftMark <= rightMark) {
      while (array.get(leftMark) < array.get(middleMark)) {
        leftMark++;
      }
      while (array.get(rightMark) > array.get(middleMark)) {
        rightMark--;
      }

      if (leftMark <= rightMark) {
        if (leftMark < rightMark) {
          swap(array, leftMark, rightMark);
        }
        leftMark++;
        rightMark--;
      }
    }
    if (leftMark < rightBorder) {
      quickSort(array, leftMark, rightBorder);
    }
    if (leftBorder < rightMark) {
      quickSort(array, leftBorder, rightMark);
    }
  }

  public static void swap(List<Integer> array, int firstIndex, int secondIndex) {
    int swap = array.get(firstIndex);
    array.set(firstIndex, array.get(secondIndex));
    array.set(secondIndex, swap);
  }
}
