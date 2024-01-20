package org.drogo.basics.problems.bs;

import java.util.Arrays;

public class FirstAndLastPosition {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 7;
        System.out.println(Arrays.toString(searchRange(nums, target)));

    }

    private static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        result[0] = search(nums, target, true);
        if (result[0] != -1) {
            result[1] = search(nums, target, false);
        }
        return result;
    }

    private static int search(int[] nums, int target, boolean findFirst) {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int midIndex = start + (end - start) / 2;
            int midNum = nums[midIndex];

            if (target == midNum) {
                //potential answer
                ans = midIndex;
                if (findFirst) {
                    end = midIndex - 1;
                } else {
                    start = midIndex + 1;
                }
            }
            if (target < midNum) {
                end = midIndex - 1;
            }
            if (target > midNum) {
                start = midIndex + 1;
            }
        }
        return ans;
    }
}
