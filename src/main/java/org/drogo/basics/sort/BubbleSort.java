package org.drogo.basics.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void sort(int[] arr) {
        boolean isSwapped = false;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - 1; j++) {
                //swap is current item is smaller than previous item
                if (arr[j] < arr[j - 1]) {
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    isSwapped = true;

                }

            }
            if (!isSwapped) {
                break;
            }
        }


    }
}
