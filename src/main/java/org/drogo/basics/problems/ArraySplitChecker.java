package org.drogo.basics.problems;

import java.util.HashMap;
import java.util.Map;

public class ArraySplitChecker {
    public static boolean isPossibleToSplit(int[] nums) {
        if (nums.length % 2 != 0) {
            return false;
        }
        Map<Integer, Integer> occurancesMap = new HashMap<>();
        for (int num : nums) {
            occurancesMap.put(num, occurancesMap.getOrDefault(num + 1, 0));
        }

        for (int count : occurancesMap.values()) {
            if (count > 2) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 4};
        System.out.println(isPossibleToSplit(nums));

    }
}
