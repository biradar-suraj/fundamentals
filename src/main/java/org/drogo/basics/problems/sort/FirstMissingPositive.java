package org.drogo.basics.problems.sort;

/*
    Leetcode problem 41.Find Missing Positive
    https://leetcode.com/problems/first-missing-positive/description/
*/
public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 0};
        int[] arr2 = {3, 4, -1, 1};
        int[] arr3 = {7, 8, 9, 11, 12};
        System.out.println(firstMissingPositive(arr1));
        System.out.println(firstMissingPositive(arr2));
        System.out.println(firstMissingPositive(arr3));

    }

    public static int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {

            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i]-1]) {
                swap(nums, i, nums[i]-1);
            }

        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1) {
                return i+1;
            }
        }
        return nums.length+1;

    }

    static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
