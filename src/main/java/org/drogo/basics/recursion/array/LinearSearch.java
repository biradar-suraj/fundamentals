package org.drogo.basics.recursion.array;

import java.util.ArrayList;
import java.util.List;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 8, 7, 7, 7, 9};
        int target = 7;
        System.out.println(search(arr, target));
        System.out.println(findIndex(arr, target, 0));
        System.out.println(findIndexFromLast(arr, target, arr.length - 1));
        findAllIndex(arr, target, 0);
        System.out.println(list);
        System.out.println(findAllIndex(arr, target, 0, new ArrayList<>()));
        System.out.println(findAllIndices(arr, target, 0));


    }

    // Using a helper function
    static int search(int[] arr, int target) {
        return helper(arr, target, 0);
    }

    static int helper(int[] arr, int target, int start) {
        if (start == arr.length) return -1;
        if (arr[start] == target) return start;

        return helper(arr, target, start + 1);
    }

    //find index from start of the array
    static int findIndex(int[] arr, int target, int index) {
        if (index == arr.length) return -1;

        if (target == arr[index]) return index;

        return findIndex(arr, target, index + 1);
    }

    //find index from end of the array
    static int findIndexFromLast(int[] arr, int target, int index) {
        if (index == -1) return -1;
        if (target == arr[index]) return index;
        return findIndexFromLast(arr, target, index - 1);
    }

    // find all the indices of a given number
    static List<Integer> list = new ArrayList<>();

    static void findAllIndex(int[] arr, int target, int index) {
        if (index == arr.length) return;

        if (target == arr[index]) {
            list.add(index);
        }
        findAllIndex(arr, target, index + 1);
    }

    //find all indices by returning a list
    static List<Integer> findAllIndex(int[] arr, int target, int index, ArrayList<Integer> list) {
        if (index == arr.length) return list;

        if (target == arr[index]) {
            list.add(index);
        }
        return findAllIndex(arr, target, index + 1, list);
    }

    //return a list but do not take it as an argument
    static List<Integer> findAllIndices(int[] arr, int target, int index) {
        List<Integer> list = new ArrayList<>();

        if (index == arr.length - 1) return list;

        if (target == arr[index]) {
            list.add(index);
        }

        List<Integer> ansFromBelowFuncCalls = findAllIndices(arr, target, index + 1);

        list.addAll(ansFromBelowFuncCalls);
        return list;


    }


}
