package org.drogo.basics.oop.abstraction;

public abstract class Parent {

    int age;

    public Parent(int age) {
        this.age = age;
    }

    static void greeting(){
        System.out.println("Hello");
    }

    abstract void career();
    abstract void partner();
}
