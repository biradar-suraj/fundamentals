package org.drogo.basics.largedata;

import java.math.BigDecimal;
import java.math.BigInteger;

/* BigInteger and BigDecimal */
public class LargeNumbers {
    public static void main(String[] args) {
        bigDecimal();

    }

    static void bigInteger() {
        int a = 30;
        int b = 67;

        BigInteger A = BigInteger.valueOf(33);
        BigInteger B = BigInteger.valueOf(345678933);
        BigInteger C = new BigInteger("2345678736389993749");
        BigInteger X = new BigInteger("45678392223736389993749");

        BigInteger D = BigInteger.TEN;

        BigInteger E = A.add(B);
        System.out.println(E);

        BigInteger multiply = C.multiply(X);
        System.out.println(multiply);

        BigInteger remainder = C.remainder(X);
        System.out.println(remainder);

        System.out.println(Factorial.factorial(23456));
    }

    static void bigDecimal() {
        double x = 0.03;
        double y = 0.04;
        double result = y - x; // answer will be 0.010000000000000002 because of some marginal error
        System.out.println(result);

        BigDecimal X = new BigDecimal("0.03");
        BigDecimal Y = new BigDecimal("0.04");
        BigDecimal result1 = Y.subtract(X); // answer will be 0.01
        System.out.println(result1);

        BigDecimal A = new BigDecimal("4567882.938775940");
        BigDecimal B = new BigDecimal("7288847992.94777294559");

        //operations
        System.out.println(B.add(A));
        System.out.println(B.subtract(A));
        System.out.println(B.multiply(A));
        System.out.println(A.pow(2));
        System.out.println(B.pow(2));
        System.out.println(B.negate());

        //constants
        BigDecimal constant1 = BigDecimal.ONE;
        BigDecimal constant2 = BigDecimal.TEN;
    }
}
