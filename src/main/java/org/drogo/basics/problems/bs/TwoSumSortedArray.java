package org.drogo.basics.problems.bs;

import java.util.Arrays;

/*   167.Two Sum II - Input Array Is Sorted
 *   https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 */
public class TwoSumSortedArray {

    static int[] twoSum(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int sum = nums[start] + nums[end];

            if (target == sum) {
                return new int[]{start + 1, end + 1};
            } else if (target < sum) {
                end = end - 1;

            } else {
                start = start + 1;
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println(Arrays.toString(twoSum(nums1, target1)));

        int[] nums2 = {2, 3, 4};
        int target2 = 6;
        System.out.println(Arrays.toString(twoSum(nums2, target2)));

        int[] nums3 = {-1, 0};
        int target3 = -1;
        System.out.println(Arrays.toString(twoSum(nums3, target3)));
    }
}
