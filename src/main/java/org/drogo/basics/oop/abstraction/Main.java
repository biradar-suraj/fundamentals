package org.drogo.basics.oop.abstraction;

public class Main {
    public static void main(String[] args) {
        Son son = new Son(30);
        son.career();

        Daughter daughter= new Daughter(28);
        daughter.partner();

        Parent.greeting();
    }
}
