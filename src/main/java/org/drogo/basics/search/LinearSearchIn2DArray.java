package org.drogo.basics.search;

import java.util.Arrays;

public class LinearSearchIn2DArray {
    public static void main(String[] args) {
        int[][] nums = {
                {23, 4, 1},
                {18, 12, 3, 9},
                {78, 99, 34, 56},
                {17, 12}
        };
        int target = 56;
        System.out.println(Arrays.toString(search(nums, target)));
    }

    private static int[] search(int[][] nums, int target) {
        for (int row = 0; row < nums.length; row++) {
            for (int col = 0; col < nums[row].length; col++) {
                if (nums[row][col] == target) {
                    return new int[]{row, col};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
