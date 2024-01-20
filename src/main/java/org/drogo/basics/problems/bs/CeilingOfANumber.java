package org.drogo.basics.problems.bs;

//Smallest number greater or equal to target
public class CeilingOfANumber {
    public static void main(String[] args) {
        int[] nums= {2,3,4,9,14,16,18};
        int target= 15;
        System.out.println(ceiling(nums, target));

    }

    private static int ceiling(int[] nums, int target){
        int start=0;
        int end= nums.length-1;

        while(start<=end){
            int midIndex= start+ (end-start)/2;
            int midNum= nums[midIndex];

            if(target==midNum){
                return midIndex;
            }
            if(target<midNum){
                end = midIndex-1;
            }
            if(target>midNum){
                start= midIndex+1;
            }
        }
        return start;

    }
}
