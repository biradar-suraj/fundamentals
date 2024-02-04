package org.drogo.basics.problems.bs;

/*   441. Arranging Coins
 *   https://leetcode.com/problems/arranging-coins/description/
 * */
public class StaircaseCoins {
    static int arrangeCoins(int n) {
        int start = 1;
        int end = n;

        while (start <= end) {
            long mid = start + (end - start) / 2;
            long sum = mid * (mid + 1) / 2;

            if (n == sum) {
                return (int) mid;
            } else if (n < sum) {
                end = (int) (mid - 1);
            } else {
                start = (int) (mid + 1);
            }
        }
        return end;
    }

    public static void main(String[] args) {
        System.out.println(arrangeCoins(8));
    }
}
