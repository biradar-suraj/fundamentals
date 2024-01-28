package org.drogo.basics.problems.linearsearch;

/*
    Leetcode 1295.Find Numbers with Even Number of Digits
    https://leetcode.com/problems/find-numbers-with-even-number-of-digits/description/
*/
public class EvenNumberOfDigits {
    public static int findNumbers(int[] nums) {
        int count = 0;

        for (int num : nums) {
            if (checkContainsEven(num)) {
                count++;
            }
        }
        return count;
    }

    private static boolean checkContainsEven(int num) {
        //int digits = String.valueOf(num).length();
        int digits = getDigits(num);
        return digits % 2 == 0;
    }

    private static int getDigits(int num) {
        if (num == 0) return 1;
        int count = 0;
        while (num > 0) {
            count++;
            num = num / 10;
        }
        return count;
    }


    //get number of digits using log10
    private static int getDigitsUsingLog(int num){
        return (int) (Math.log10(num)+1);
    }

    public static void main(String[] args) {
        int[] nums1 = {12, 345, 2, 6, 7896};
        int[] nums2 = {555, 901, 482, 1771};


        System.out.println(findNumbers(nums1));
        System.out.println(findNumbers(nums2));
    }
}
