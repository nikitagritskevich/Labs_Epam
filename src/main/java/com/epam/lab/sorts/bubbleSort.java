package com.epam.lab;

import java.util.Arrays;
import java.util.List;

public class bubbleSort {

    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(2, 15, -10, 170, 27, 300);
        bubbleSort(array);
        System.out.println(array);
    }

    public static void bubbleSort(List<Integer> array) {
        for (int i = 0; i < array.size(); i++) {
            for (int j = 1; j < (array.size() - i); j++) {
                if (array.get(j) < array.get(j - 1)) {
                    swap(array, j, j - 1);
                }
            }
        }
    }

    public static void swap(List<Integer> array, int firstIndex, int lastIndex) {
        int swap = array.get(firstIndex);
        array.set(firstIndex, array.get(lastIndex));
        array.set(lastIndex, swap);

    }
}
