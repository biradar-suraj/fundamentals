package org.drogo.basics.problems.sort;

/*
    Leetcode problem 265.Missing Number
    https://leetcode.com/problems/missing-number/description/
*/
public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        int[] nums1 = {3,0,1};
        System.out.println(missingNumber(nums1));

    }

    private static int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {

            while (nums[i] < nums.length && nums[i] != nums[nums[i]]) {
                swap(nums, i, nums[i]);
            }

        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;

    }


    private static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
