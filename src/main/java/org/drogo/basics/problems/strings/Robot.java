package org.drogo.basics.problems.strings;

import java.util.Arrays;

public class Robot {
    public static void main(String[] args) {
        String sequence = "LLDD"; // replace this with your input sequence
        int[] finalPosition = robotMovementProcess(sequence);
        System.out.println(Arrays.toString(finalPosition));
    }

    static int[] robotMovementProcess(String str) {
        int xCounter = 0;
        int yCounter = 0;
        for (char direction :
                str.toCharArray()) {
            if (direction != 'L' && direction != 'R' && direction != 'U' && direction != 'D') {
                System.out.println("Invalid move: " + direction);
                continue;
            }
            if (direction == 'R') {
                xCounter++;
            }
            if (direction == 'U') {
                yCounter++;
            }
            if (direction == 'L') {
                xCounter--;
            }
            if (direction == 'D') {
                yCounter--;
            }
        }
        return new int[]{xCounter, yCounter};
    }
}
