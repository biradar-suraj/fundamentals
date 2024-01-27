package org.drogo.basics.recursion.sorting;

import java.util.Arrays;

/*
    Divide array into 2  parts
    Sort both parts using Recursion
    Merge the sorted parts
*/
public class MergeSort {
    static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }

        int mid = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return mergeTwoArrays(left, right);
    }

    private static int[] mergeTwoArrays(int[] first, int[] second) {
        int[] mergedArray = new int[first.length + second.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                mergedArray[k] = first[i];
                i++;
            }
            if (second[j] < first[i]) {
                mergedArray[k] = second[j];
                j++;
            }
            k++;
        }

        while (i < first.length) {
            mergedArray[k] = first[i];
            i++;
            k++;
        }

        while (j < second.length) {
            mergedArray[k] = second[j];
            j++;
            k++;
        }

        return mergedArray;
    }

    static void mergeSortInPlace(int[] arr, int start, int end) {
        if (end - start == 1) {
            return;
        }

        int mid = start + (end - start) / 2;
        mergeSortInPlace(arr, start, mid);
        mergeSortInPlace(arr, mid, end);

        mergeInPlace(arr, start, mid, end);
    }

    private static void mergeInPlace(int[] arr, int start, int mid, int end) {
        int[] mergedArray = new int[end - start];

        int i = start;
        int j = mid;
        int k = 0;

        while (i < mid && j < end) {
            if (arr[i] < arr[j]) {
                mergedArray[k] = arr[i];
                i++;
            }
            if (arr[j] < arr[i]) {
                mergedArray[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i < mid) {
            mergedArray[k] = arr[i];
            i++;
            k++;
        }

        while (j < end) {
            mergedArray[k] = arr[j];
            j++;
            k++;
        }

        for (int l = 0; l < mergedArray.length; l++) {
            arr[start + l] = mergedArray[l];
        }
    }


    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        int[] sortedArray = mergeSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(sortedArray));
        mergeSortInPlace(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));


    }
}
