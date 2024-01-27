package org.drogo.basics.recursion.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        sort(arr, 0, arr.length, 0);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr, int col, int row, int max) {
        if (row == 0) {
            return;
        }
        if (col < row) {
            if (arr[col] > arr[max]) {
                sort(arr, col + 1, row, col);
            } else {
                sort(arr, col + 1, row, max);
            }

        } else {
            int temp = arr[max];
            arr[max] = arr[row - 1];
            arr[row - 1] = temp;

            sort(arr, 0, row - 1, 0);
        }
    }
}
