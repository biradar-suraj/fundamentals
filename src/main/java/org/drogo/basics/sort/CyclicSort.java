package org.drogo.basics.sort;

import java.util.Arrays;

/*
    when given a range from 1 to N use cyclic sort
*/
public class CyclicSort {
    public static void main(String[] args) {
        int[] arr = {5,4,2,3,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int correctIndex = arr[i] - 1;
            if (arr[i] != arr[correctIndex]) {
                swap(arr, i, correctIndex);
            }
        }
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
