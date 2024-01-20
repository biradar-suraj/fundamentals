package org.drogo.basics.oop;

//This is a demo to show initialisation of static variables
public class StaticBlock {

    static int a= 4;
    static int b;

    static{
        System.out.println("Inside a static block");
        b= a*5;
    }

    public static void main(String[] args) {
        System.out.println(StaticBlock.a);
        System.out.println(StaticBlock.b);

    }
}
