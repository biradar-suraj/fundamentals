package org.drogo.basics.problems;

public class LeadersInArray {
    public static void main(String[] args) {
        int[] nums = {8, 11, 5, 11, 7, 6, 3};
        leadersInArray(nums);
        optimisedApproach(nums);

    }

    //    naive approach
    public static void leadersInArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean isLeader = true;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] >= nums[i]) {
                    isLeader = false;
                    break;
                }

            }
            if (isLeader) {
                System.out.println(nums[i]);
            }
        }
    }

    //    optimised approach
    public static void optimisedApproach(int[] nums) {
        int currentLeader = nums[nums.length - 1];
        System.out.println(currentLeader);

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > currentLeader) {
                currentLeader = nums[i];
                System.out.println(currentLeader);
            }

        }
    }


}
