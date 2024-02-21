package org.drogo.basics.linkedlist.problems;

/* 202. Happy Number
 *  https://leetcode.com/problems/happy-number/description/ */
public class HappyNumber {
    public static boolean isHappy(int num) {
        int slow = num;
        int fast = num;

        do {
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));

        } while (fast != slow);

        if (slow == 1) {
            return true;
        }
        return false;

    }

    private static int findSquare(int num) {
        int ans = 0;
        while (num > 0) {
            int rem = num % 10;
            ans += rem * rem;
            num = num / 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
        System.out.println(isHappy(2));
    }
}
