package org.drogo.basics.search;

public class OrderAgnosticBinarySearch {
    public static void main(String[] args) {
        int[] nums={2,3,5,7,8,9,11};
        int[] nums2={13,11,9,7,4,2,1};
        int target= 9;
        System.out.println(orderAgnosticBinarySearch(nums, target));
        System.out.println(orderAgnosticBinarySearch(nums2, target));

    }

    private static int orderAgnosticBinarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        boolean isAscending = nums[start] < nums[end];

        while (start <= end) {
            int middlePosition = start + (end - start) / 2;
            int middleNumber = nums[middlePosition];

            if (target == middleNumber) {
                return middlePosition;
            }

            if (isAscending) {
                if (target < middleNumber) {
                    end = middlePosition - 1;
                }
                if (target > middleNumber) {
                    start = middlePosition + 1;
                }

            } else {
                if (target < middleNumber) {
                    start = middlePosition + 1;
                }
                if (target > middleNumber) {
                    end = middlePosition - 1;
                }

            }

        }
        return -1;

    }
}
