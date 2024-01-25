package org.drogo.basics.recursion.level1;

public class Sum {
    public static void main(String[] args) {
        System.out.println(findSumOfNnumbers(5));

    }

    static int findSumOfNnumbers(int n) {
        if (n <= 1) {
            return 1;

        }

        return n + findSumOfNnumbers(n - 1);
    }
}
