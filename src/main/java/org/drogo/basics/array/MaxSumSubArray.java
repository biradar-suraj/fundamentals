package org.drogo.basics.array;

public class MaxSumSubArray {
    public static int maxSubArray(int[] nums, int k) {
        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        for (int i = k; i < nums.length; i++) {
            windowSum = windowSum - nums[i - k] + nums[i];
            maxSum = Math.max(windowSum, maxSum);

        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {2, 9, 31, -4, 21, 7};
        int k = 3;
        System.out.println(maxSubArray(nums, k));
    }
}
