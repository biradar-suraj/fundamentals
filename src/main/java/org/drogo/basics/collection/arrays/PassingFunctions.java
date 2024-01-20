package org.drogo.basics.collection.arrays;

import java.util.Arrays;

public class PassingFunctions {
    public static void main(String[] args) {
        int[] nums={3,4,5,12};
        System.out.println(Arrays.toString(nums));
        change(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void change(int[] nums) {
        nums[0]=99;
    }
}
