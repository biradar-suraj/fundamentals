package org.drogo.basics.recursion.sorting;

import java.util.Arrays;
import java.util.Random;

public class QuickSort2 {

    private static void quickSort(int[] arr, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) return;

        //random pivot
        /*int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, highIndex);*/

        int pivot = arr[highIndex];

        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (leftPointer < rightPointer) {

            while (arr[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
            while (arr[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }

            swap(arr, leftPointer, rightPointer);
        }

        swap(arr, leftPointer, highIndex);

        quickSort(arr, lowIndex, leftPointer - 1);
        quickSort(arr, leftPointer + 1, highIndex);

    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
