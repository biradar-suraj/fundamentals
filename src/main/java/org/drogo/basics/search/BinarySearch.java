package org.drogo.basics.search;

public class BinarySearch {

    public static void main(String[] args) {
        int[] nums={1,2,4,5,7,9,11};
        int index = binarySearch(nums, 9);
        System.out.println(index);

    }

    public static int binarySearch(int[] nums, int target){
        int start=0;
        int end=nums.length-1;

        while (start<=end){
            int middlePosition= start+(end-start)/2;
            int middleNumber= nums[middlePosition];

            if(target==middleNumber){
                return middlePosition;
            }
            if(target<middleNumber){
                end=middlePosition-1;
            }else{
                start=middlePosition+1;
            }

        }
        return -1;

    }
}
