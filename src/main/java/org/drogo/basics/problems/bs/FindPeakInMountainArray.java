package org.drogo.basics.problems.bs;

public class FindPeakInMountainArray {
    public static void main(String[] args) {

    }

    public int peakIndexInMountainArray(int[] arr) {
        int start=0;
        int end= arr.length-1;


        while(start<end){
            int mid= start+(end-start)/2;

            if(arr[mid]>arr[mid+1]){
                // descending part of the array
                end= mid;
            }else{
                // ascending part of the array
                start= mid+1;
            }
        }
        return start; //return start/end as both are equal

    }
}
