package org.drogo.basics.problems.bs;

/*   367. Valid Perfect Square
 *   https://leetcode.com/problems/valid-perfect-square/description/
 */
public class ValidPerfectSquare {

    public static boolean isPerfectSquare(int num) {
        int start = 1;
        int end = num;

        while (start <= end) {
            long mid = start + (end - start) / 2;

            if (num == mid * mid) {
                return true;
            } else if (num > mid * mid) {
                start = (int) (mid + 1);
            } else {
                end = (int) (mid - 1);
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int num = 2147483647;
        System.out.println(isPerfectSquare(num));
    }
}
