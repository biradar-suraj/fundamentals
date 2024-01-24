package org.drogo.basics.recursion;

/*
    Recursion helps in solving bigger/complex problems in a simple way
    We can convert recursion solution into iteration and vice versa
    Space complexity is not constant

    Break down bigger problem into smaller problems
    Write recurrence relation
    Draw recursive tree
    About the tree
        flow of functions, function stack
        identify and focus on left tree calls and right tree calls
    See how the values are returned on each step
*/
public class Recursion {

    public static void main(String[] args) {
        print(1);
    }

    private static void print(int n) {
        // base condition
        if(n==5){
            System.out.println(5);
            return;
        }
        // body
        System.out.println(n);


        print(n+1); //tail recursion
    }
}
