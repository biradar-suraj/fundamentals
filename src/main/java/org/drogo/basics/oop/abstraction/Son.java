package org.drogo.basics.oop.abstraction;

public class Son extends Parent{
    public Son(int age) {
        super(age);
    }

    @Override
    void career() {
        System.out.println("Son wants to be a Doctor");

    }

    @Override
    void partner() {
        System.out.println("Son wants to marry a beautiful girl");

    }
}
