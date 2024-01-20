package org.drogo.basics.problems.bs;

public class FindInMountainArray {

    public static void main(String[] args) {

    }

    private static int findInMountainArray(int[] nums, int target){
        int peak = peakInMountainArray(nums);
        int ascendingResult = orderAgnosticBinarySearch(nums, target, 0, peak);
        if(ascendingResult!=-1){
            return ascendingResult;
        }
        return orderAgnosticBinarySearch(nums,target,peak+1, nums.length-1);
    }

    private static int peakInMountainArray(int[] nums){
        int start=0;
        int end= nums.length-1;

        while(start<end){
            int mid= start+(end-start)/2;
            if(nums[mid]>nums[mid+1]){
                end= mid;
            }else{
                start=mid+1;
            }

        }
        return start;
    }

    private static int orderAgnosticBinarySearch(int[] nums, int target,int start, int end){
        boolean isAscending= nums[start]<nums[end];

        while(start<=end){
            int mid= start+(end-start)/2;
            int midNumber=nums[mid];

            if(target==midNumber) return mid;

            if(isAscending){
                if(target<midNumber){
                    end= mid-1;
                }
                if(target>midNumber){
                    start=mid+1;
                }
            }else{
                if(target<midNumber){
                    start=mid+1;
                }
                if(target>midNumber){
                    end=mid-1;
                }

            }
        }
        return -1;
    }
}
