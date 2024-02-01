package org.drogo.basics.recursion;

/*
    Fib(N)= Fib(N-1)+ Fib(N-2)  recurrence relation
    Base condition
    Fib(0)=0
    Fib(1)=1

*/
public class Fibonacci {
    public static void main(String[] args) {
        int n = 6;
        int fibOf6 = fib(4);
        System.out.println(fibOf6);
        for (int i = 0; i < n; i++) {
            System.out.println(fib(i));

        }

    }

    static int fib(int n) {
        if (n < 2) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    static void fibBruteForce(int n) {
        int t1 = 0;
        int t2 = 1;
        while (n >= 1) {
            System.out.println(t1 + " ");
            int sum = t1 + t2;
            t1 = t2;
            t2 = sum;
            n--;

        }

    }
}
