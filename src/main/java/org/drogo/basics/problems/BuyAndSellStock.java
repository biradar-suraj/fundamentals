package org.drogo.basics.problems;

/*  121. Best Time to Buy and Sell Stock
    https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/ */
public class BuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;

        for (int price : prices) {
            if (price < min) {
                min = price;
            }
            profit = Math.max(profit, price - min);
        }

        return profit;

    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices1 = {7,6,4,3,1};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfit(prices1));
    }
}
