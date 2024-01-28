package org.drogo.basics.search;

public class SearchInRange {
    public static void main(String[] args) {
        int[] nums = {18, 12, -7, 3, 14, 28};
        int target = 18;
        System.out.println(search(nums, target, 0, 0));

    }

    static int search(int[] arr, int target, int start, int end) {
        if(start>end) return -1;
        for (int i = start; i <= end; i++) {
            if (target == arr[i]) {
                return i;
            }

        }
        return -1;
    }
}
