package org.drogo.basics.problems.sort;

/*
    Leetcode problem 645.Set Mismatch
    https://leetcode.com/problems/set-mismatch/description/
*/

import java.util.Arrays;

public class SetMismatch {

    public static void main(String[] args) {
        int[] arr1={1,2,2,4};
        int[] arr2={1,1};
        System.out.println(Arrays.toString(findErrorNums(arr1)));
        System.out.println(Arrays.toString(findErrorNums(arr2)));

    }

    static int[] findErrorNums(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i]-1);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return new int[]{nums[i], i + 1};
            }
        }
        return new int[]{-1, -1};

    }

    static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
