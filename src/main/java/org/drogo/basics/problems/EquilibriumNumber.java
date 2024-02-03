package org.drogo.basics.problems;

import java.util.Arrays;
import java.util.List;

public class EquilibriumNumber {

    static int findEquilibriumNumber(List<Integer> arr) {
        int n = arr.size();
        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < n; i++) {
            rightSum = rightSum + arr.get(i);
        }

        for (int i = 0; i < n; i++) {
            rightSum = rightSum - arr.get(i);

            if (leftSum == rightSum) {
                return arr.get(i);
            }

            leftSum = leftSum + arr.get(i);
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,2,3,3);
        System.out.println(findEquilibriumNumber(nums));
    }
}
