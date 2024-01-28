package org.drogo.basics.problems.linearsearch;

/*  Leetcode 1672. Richest Customer Wealth
    https://leetcode.com/problems/richest-customer-wealth/description/

*/
public class RichestCustomerWealth {
    public static int maximumWealth(int[][] accounts) {
        int answer = Integer.MIN_VALUE;
        for (int person = 0; person < accounts.length; person++) {
            int sum = 0;
            for (int account = 0; account < accounts[person].length; account++) {
                sum = sum + accounts[person][account];

            }
            if (sum > answer) {
                answer = sum;
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] accounts1 = {
                {1, 2, 3},
                {3, 2, 1}
        };

        int[][] accounts2 = {
                {1, 5},
                {7, 3},
                {3, 5}
        };

        System.out.println(maximumWealth(accounts1));
        System.out.println(maximumWealth(accounts2));

    }
}
