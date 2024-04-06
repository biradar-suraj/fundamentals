package org.drogo.basics.cleancode;

import java.math.BigInteger;

public class IntOverflowBigInt {

    public static void main(String[] args) {
        try {
            int result = safeAdd(Integer.MAX_VALUE, 1);
            System.out.println("No integer overflow");
        } catch (ArithmeticException e) {
            System.out.println("Integer overflow detected");
        }
    }

    private static int safeAdd(int left, int right) throws ArithmeticException {
        BigInteger tempSum = BigInteger.valueOf(left).add(BigInteger.valueOf(right));
        BigInteger finalSum = intRangeCheck(tempSum);

        return finalSum.intValue();

    }

    private static final BigInteger bigMaxInt = BigInteger.valueOf(Integer.MAX_VALUE);
    private static final BigInteger bigMinInt = BigInteger.valueOf(Integer.MIN_VALUE);

    private static BigInteger intRangeCheck(BigInteger value) throws ArithmeticException {
        if (value.compareTo(bigMaxInt) > 0 || value.compareTo(bigMinInt) < 0) {
            throw new ArithmeticException("Integer overflow");
        }
        return value;
    }


}
