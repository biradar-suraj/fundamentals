package org.drogo.basics.largedata;

import java.math.BigInteger;

public class Factorial {

    static BigInteger factorial(int number) {
        BigInteger ans = new BigInteger("1");

        for (int i = 2; i <= number; i++) {
            ans = ans.multiply(BigInteger.valueOf(i));

        }
        return ans;
    }
}
