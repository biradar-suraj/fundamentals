package org.drogo.basics.recursion.array;

public class Sorted {

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 6, 7, 9, 8};
        System.out.println(sorted(arr, 0));

    }

    public static boolean sorted(int[] arr, int index) {
        if (index == arr.length - 1) return true; //base condition

        return arr[index] < arr[index + 1] && sorted(arr, index + 1);

    }
}
