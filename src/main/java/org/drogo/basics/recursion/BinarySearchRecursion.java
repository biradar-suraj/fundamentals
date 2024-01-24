package org.drogo.basics.recursion;

public class BinarySearchRecursion {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5, 11, 15, 18, 22, 36};
        int target = 22;
        System.out.println(search(nums, target, 0, nums.length - 1));

    }

    static int search(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;
        if (target == nums[mid]) {
            return mid;
        }
        if (target < nums[mid]) {
            return search(nums, target, start, mid - 1);
        }
        if (target > nums[mid]) {
            return search(nums, target, mid + 1, end);
        }

        return -1;

    }
}
