package org.drogo.basics.problems.bs;

/*  153. Find Minimum in Rotated Sorted Array
    https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/ */
public class FindMinInSortedArray {
    public static int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int answer = nums[0];

        if (nums.length == 1) {
            return nums[0];
        }

        while (start <= end) {
            if (nums[start] < nums[end]) {
                answer = Math.min(answer, nums[start]);
            }

            int mid = start + (end - start) / 2;
            answer = Math.min(answer, nums[mid]);

            if (nums[start] <= nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return answer;

    }

    public static void main(String[] args) {
        int[] nums1 = {3, 4, 5, 1, 2};
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int[] nums3 = {11, 13, 15, 17};
        System.out.println(findMin(nums1));
        System.out.println(findMin(nums2));
        System.out.println(findMin(nums3));
    }
}
