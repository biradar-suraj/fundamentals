package org.drogo.basics.problems.bs.guessnumber;

/*  374. Guess Number Higher or Lower
 *   https://leetcode.com/problems/guess-number-higher-or-lower/description/
 * */
public class GuessNumberHigherOrLower {

    public static int guessNumber(int n, int pick) {
        NumberGuesser numberGuesser = new NumberGuesser(pick);
        int start = 1;
        int end = n;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int guess = numberGuesser.guess(mid);

            if (guess == 0) {
                return mid;
            }
            if (guess > 0) {
                start = mid + 1;

            }
            if (guess < 0) {
                end = mid - 1;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        System.out.println(guessNumber(10, 6));
    }
}
