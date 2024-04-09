package org.drogo.basics.problems;

/*  53. Maximum Subarray
    https://leetcode.com/problems/maximum-subarray/description/ */
public class MaximumSubArray {
    public static int maxSubArray(int[] nums) {
        int currentSum = 0;
        int maximumSum = nums[0];

        for (int num : nums) {
            if (currentSum < 0) {
                currentSum = 0;
            }
            currentSum = currentSum + num;
            maximumSum = Math.max(currentSum, maximumSum);
        }
        return maximumSum;

    }

    public static void main(String[] args) {
        int[] arr1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] arr2 = {1};
        int[] arr3 = {5, 4, -1, 7, 8};
        System.out.println(maxSubArray(arr1));
        System.out.println(maxSubArray(arr2));
        System.out.println(maxSubArray(arr3));

    }
}
