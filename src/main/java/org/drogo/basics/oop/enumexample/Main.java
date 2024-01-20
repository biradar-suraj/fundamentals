package org.drogo.basics.oop.enumexample;

public class Main {

    public static void main(String[] args) {
        Week week= Week.Thursday;

        System.out.println(week);

        for (Week day: Week.values()) {
            System.out.println(day);

        }

        System.out.println(week.ordinal());

    }
}
