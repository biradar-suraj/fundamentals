package org.drogo.basics.problems.sort;

import java.util.ArrayList;
import java.util.List;

/*
    Leetcode problem 442.Find All Duplicates in an Array
    https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
*/
public class FindAllDuplicatedInAnArray {
    public static void main(String[] args) {
        int[] arr1 = {4, 3, 2, 7, 8, 2, 3, 1};
        int[] arr2= {1,1,2};
        int[] arr3={1};
        System.out.println(findDuplicates(arr1));
        System.out.println(findDuplicates(arr2));
        System.out.println(findDuplicates(arr3));


    }

    static List<Integer> findDuplicates(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                list.add(nums[i]);
            }
        }
        return list;
    }

    static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
