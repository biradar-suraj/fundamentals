package org.drogo.basics.problems;

/*  26. Remove Duplicates from Sorted Array
    https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/ */
public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        int rd = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[rd] != nums[i]) {
                rd++;
                nums[rd] = nums[i];
            }

        }
        return rd + 1;

    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 3, 4, 6, 6};
        for (int num : nums) {
            System.out.print(num + " ");
        }
        int rd = removeDuplicates(nums);
        System.out.println();
        for (int i = 0; i < rd; i++) {
            System.out.print(nums[i] + " ");
        }

    }
}
