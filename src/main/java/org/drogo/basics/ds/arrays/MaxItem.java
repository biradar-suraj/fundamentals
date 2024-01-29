package org.drogo.basics.ds.arrays;

import java.util.Arrays;

public class MaxItem {
    public static void main(String[] args) {
        int[] arr= {88,3,22,9,1,5};
        System.out.println(Arrays.toString(arr));
        int maxItem = maxItem(arr);
        int maxItemInRange = maxItemInRange(arr, 1, 4);
        System.out.println("Maximum value in the array is: "+maxItem);
        System.out.println("Maximum value in the given range is: "+maxItemInRange);

    }

    private static int maxItemInRange(int[] arr, int start, int end) {
        int maxItem= arr[start];
        for (int i = start; i <= end; i++) {
            if(arr[i]>maxItem){
                maxItem=arr[i];
            }

        }
        return maxItem;
    }

    private static int maxItem(int[] arr) {
        int max=arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>max){
                max=arr[i];
            }

        }
        return max;
    }
}
