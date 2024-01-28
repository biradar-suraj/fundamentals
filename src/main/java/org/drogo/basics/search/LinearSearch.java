package org.drogo.basics.search;

public class LinearSearch {

    static int linearSearch(int[] arr, int target) {
        if (arr.length == 0) return -1;
        for (int i = 0; i < arr.length; i++) {
            if (target == arr[i]) {
                return i;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 5, 7, 8, 9};
        int target = 8;
        System.out.println(linearSearch(nums, target));
    }
}
