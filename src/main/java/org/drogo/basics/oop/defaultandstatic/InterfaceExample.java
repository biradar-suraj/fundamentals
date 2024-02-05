package org.drogo.basics.oop.defaultandstatic;

public interface InterfaceExample {
    default void defaultMethod() {
        System.out.println("This is a default method in the interface");
    }

    static void staticMethod() {
        System.out.println("This is a static method in the interface.");
    }
}
