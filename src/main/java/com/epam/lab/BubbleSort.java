package com.epam.lab;

import java.util.Arrays;
import java.util.List;

public class BubbleSort {

    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(2, 10, -200, 25, 300, 13, 179, 0, -15, 29);
        bubbleSort(array);
        System.out.println(array);

    }

    public static void bubbleSort(List<Integer> array) {
        for (int i = 0; i < array.size(); i++) {
            for (int j = 1; j < (array.size() - i); j++) {
                if (array.get(j - 1) > array.get(j)) {
                    swap(array, j - 1, j);
                }
            }
        }
    }

    public static void swap(List<Integer> array, int firstIndex, int secondIndex) {
        int tempVariable = array.get(firstIndex);
        array.set(firstIndex, array.get(secondIndex));
        array.set(secondIndex, tempVariable);
    }
}
