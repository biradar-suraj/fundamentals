package org.drogo.basics.problems.recursion;

public class ReduceToZero {

    public static void main(String[] args) {
        int num1=14;
        int num2=8;
        int num3=123;
        System.out.println(numberOfSteps(num1));
        System.out.println(numberOfSteps(num2));
        System.out.println(numberOfSteps(num3));

    }

    public static int numberOfSteps(int num){
        return helper(num, 0);
    }

    private static int helper(int num, int steps){
        if(num==0) return steps;

        if(num%2==0){
            return helper(num/2,steps+1);
        }
        return helper(num-1,steps+1);
    }
}
