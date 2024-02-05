package org.drogo.basics.oop.defaultandstatic;

public class MainClass {
    public static void main(String[] args) {
        ClassExample classExample = new ClassExample();
        classExample.defaultMethod();
        InterfaceExample.staticMethod();
    }
}
