package org.drogo.basics.sorting;

import java.util.Arrays;

public class CyclicSortImp {

    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 2, 1};
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    static void cyclicSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] != arr[arr[i] - 1]) {
                swap(arr, i, arr[i] - 1);
            }
        }
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
