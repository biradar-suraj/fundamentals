package org.drogo.basics.oop.enumexample;

public enum Week {
    Monday,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday,
    Sunday;

    Week() {
        System.out.println("Week enum constructor");
    }

    void hello(){
         System.out.println("Hello from Week ENUM");

    }
}
