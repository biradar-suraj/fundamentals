package org.drogo.basics.problems;

public class CalculateSumDigitNum {

    public static void main(String[] args) {
        System.out.println(calc("1234c"));

    }

    private static int calc(String s) {
        int sum = 0;
        for (char ch :
                s.toCharArray()) {
            if (Character.isDigit(ch)) {
                sum += Character.getNumericValue(ch);
            } else if (Character.isLetter(ch)) {
                sum += 1 + Character.toLowerCase(ch) - 'a';
            } else {
                throw new IllegalArgumentException("Invalid character: " + ch);
            }

        }
        return sum;
    }
}
