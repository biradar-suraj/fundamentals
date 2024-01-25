package org.drogo.basics.recursion.level1;

public class DigitSum {
    public static void main(String[] args) {
        int num = 1111;
        System.out.println(findSum(num));

        System.out.println(num--);
        System.out.println(num);
        System.out.println(--num);
    }

    static int findSum(int num) {
        if (num == 0) {
            return 0;
        }

        return (num % 10) + findSum(num / 10);
    }
}
