package org.drogo.basics.problems.bs;

//Do not use array length
public class PositionInfiniteArray {
    public static void main(String[] args) {
        int[] nums={3,5,7,8,9,13,17,19,21,23,25,28,30,31,56,78,99,123,145,178};
        int target= 17;
        System.out.println(findPosition(nums, target));


    }

    private static int findPosition(int[] nums, int target) {
        int start = 0;
        int end = 1;

        while (target > nums[end]) {
            int newStart = end + 1;
           end = end + (end - start + 1) * 2;
            start= newStart;
        }
        return binarySearch(nums,target,start,end);
    }

    public static int binarySearch(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int middlePosition = start + (end - start) / 2;
            int middleNumber = nums[middlePosition];

            if (target == middleNumber) {
                return middlePosition;
            }
            if (target < middleNumber) {
                end = middlePosition - 1;
            } else {
                start = middlePosition + 1;
            }

        }
        return -1;

    }
}
