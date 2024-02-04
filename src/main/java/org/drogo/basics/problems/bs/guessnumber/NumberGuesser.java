package org.drogo.basics.problems.bs.guessnumber;

public class NumberGuesser implements Guesser {
    private final int pick;

    public NumberGuesser(int pick) {
        this.pick = pick;
    }

    @Override
    public int guess(int num) {
        if (num == pick) {
            return 0;
        }
        if (num < pick) {
            return 1;
        }
        return -1;
    }
}
