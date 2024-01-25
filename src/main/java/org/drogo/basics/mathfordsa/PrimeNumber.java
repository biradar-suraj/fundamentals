package org.drogo.basics.mathfordsa;

public class PrimeNumber {
    public static void main(String[] args) {
        int num = 20;
        for (int i = 1; i <= num; i++) {
            System.out.println(i + " " + checkForPrime(i));

        }
    }

    static boolean checkForPrime(int num) {
        if (num <= 1) {
            return false;
        }

        int c = 2;
        while (c * c <= num) {
            if (num % c == 0) {
                return false;
            }
            c++;
        }
        return true;
    }


}
