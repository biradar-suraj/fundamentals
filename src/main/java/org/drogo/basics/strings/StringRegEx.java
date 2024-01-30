package org.drogo.basics.strings;

public class StringRegEx {

    public static void main(String[] args) {

        String email = "suraj.biradar@xyz.com";
        String[] strings = email.split("@");
        String namePart = strings[0];
        String[] names = namePart.split("\\.");
        String firstName = names[0];
        String lastName= names[1];
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(strings[1]);


    }
}
