package org.drogo.basics.problems;

import java.util.Arrays;

/*  283. Move Zeroes
    https://leetcode.com/problems/move-zeroes/description/ */
class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int size = nums.length;
        if (size == 0 || size == 1) {
            return;
        }

        int nz = 0;
        int z = 0;

        while (nz < size) {
            if (nums[nz] != 0) {
                int temp = nums[nz];
                nums[nz] = nums[z];
                nums[z] = temp;
                nz++;
                z++;
            } else {
                nz++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}