package org.drogo.basics.array;

import java.util.Arrays;
import java.util.Comparator;

public class SecondLargest {
    public static int secondLargest(int[] nums) {
        int max1 = 0, max2 = 0;
        if (nums[0] > nums[1]) {
            max1 = nums[0];
            max2 = nums[1];

        } else {
            max1 = nums[1];
            max2 = nums[0];
        }

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > max1) {
                max2 = max1;
                max1 = nums[i];
            } else if (nums[i] > max2) {
                max2 = nums[i];
            }
        }
        return max2;
    }


    public static void main(String[] args) {
        int[] nums = {20, 47, 6, 25, 30, 88};
        System.out.println(secondLargest(nums));
        Arrays.stream(nums)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst().ifPresent(System.out::println);

    }
}
