package org.drogo.basics.streams;

import java.util.Arrays;
import java.util.List;

public class EvenOdd {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        System.out.println(isOddArray(nums));

        /* using streams */
        boolean result = nums.stream().anyMatch(num -> num % 2 == 0);
        System.out.println(!result);

        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(3, 1, 2);

        System.out.println(list1.containsAll(list2));
        System.out.println(list1.equals(list2));

    }

    private static boolean isOddArray(List<Integer> nums) {
        for (int num : nums) {
            if (num % 2 == 0) {
                return false;
            }
        }

        return true;
    }
}
