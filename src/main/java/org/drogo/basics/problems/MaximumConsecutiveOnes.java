package org.drogo.basics.problems;

public class MaximumConsecutiveOnes {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxCount = 0;

        for (int num : nums) {
            if (num == 0) {
                count = 0;
            } else {
                count++;
                maxCount = Math.max(count, maxCount);
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));

    }
}
