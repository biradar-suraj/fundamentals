package org.drogo.basics.problems.sort;

//alternate version
public class MissingNumber2 {
    public static void main(String[] args) {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(missingNumber(nums));
    }

    private static int missingNumber(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int expectedTotal = n * (n + 1) / 2;
        for (int num : nums) {
            expectedTotal = expectedTotal - num;

        }
        return expectedTotal;
    }
}
