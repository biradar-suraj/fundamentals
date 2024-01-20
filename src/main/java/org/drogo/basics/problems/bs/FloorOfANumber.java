package org.drogo.basics.problems.bs;

//Greatest number smaller or equal to target
public class FloorOfANumber {
    public static void main(String[] args) {
        int[] nums= {2,3,4,9,14,16,18};
        int target= 15;
        System.out.println(floor(nums, target));

    }

    private static int floor(int[] nums, int target){
        int start=0;
        int end= nums.length-1;

        while(start<=end){
            int midIndex= start + (end - start)/2;
            int midNum= nums[midIndex];

            if(target==midNum){
                return midIndex;
            }
            if(target<midNum){
                end= midIndex-1;
            }
            if(target>midNum){
                start=midIndex+1;
            }
        }
        return end;

    }
}
