package org.drogo.basics.cleancode;

public class IntOverflowCheck {
    public static void main(String[] args) {

        try {
            int result = safeAdd(Integer.MAX_VALUE, 1);
            System.out.println("No integer overflow");
        } catch (ArithmeticException e) {
            System.out.println("Integer overflow detected");
        }
    }

    //    pre-condition testing
    static int safeAdd(int left, int right) throws ArithmeticException {

        if (right > 0 ? left > Integer.MAX_VALUE - right
                : left < Integer.MIN_VALUE - right) {
            throw new ArithmeticException("Integer overflow");
        }
        return left + right;
    }

    //    upcasting
    static int safeAddWithUpcasting(int left, int right) throws ArithmeticException {

        if (right > 0 ? left > Integer.MAX_VALUE - right
                : left < Integer.MIN_VALUE - right) {
            throw new ArithmeticException("Integer overflow");
        }
        return left + right;
    }

    static long intRangeCheck(long value) throws ArithmeticException {
        if (value < Integer.MIN_VALUE || value > Integer.MAX_VALUE) {
            throw new ArithmeticException("Integer overflow");
        }
        return value;
    }

}
