package org.drogo.basics.problems;

import java.util.HashSet;
import java.util.Set;

/*  217. Contains Duplicate
    https://leetcode.com/problems/contains-duplicate/description/ */
public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> visited = new HashSet<>();
        for (int num : nums) {
            if (visited.contains(num)) {
                return true;
            } else {
                visited.add(num);
            }

        }
        return false;

    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        int[] nums2 = {1, 2, 3, 4};
        int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};

        System.out.println(containsDuplicate(nums1));
        System.out.println(containsDuplicate(nums2));
        System.out.println(containsDuplicate(nums3));
    }
}
