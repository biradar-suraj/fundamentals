package org.drogo.basics.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumSwapsToSort {

    static int findMinimumSwaps(int[] arr) {
        int n = arr.length;
        int[] arrCopy = Arrays.copyOf(arr, n);
        Arrays.sort(arrCopy);
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            hashMap.put(arrCopy[i], i);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            while (hashMap.get(arr[i]) != i) {
                count++;
                swap(arr, i, hashMap.get(arr[i]));
            }

        }
        return count;
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 4, 5, 3, 2};
        System.out.println(findMinimumSwaps(arr));
    }
}
