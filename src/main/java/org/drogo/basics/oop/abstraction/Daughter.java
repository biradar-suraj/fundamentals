package org.drogo.basics.oop.abstraction;

public class Daughter extends Parent{
    public Daughter(int age) {
        super(age);
    }

    @Override
    void career() {
        System.out.println("Daughter wants to be an Architect");

    }

    @Override
    void partner() {
        System.out.println("Daughter wants to marry a handsome guy");

    }
}
