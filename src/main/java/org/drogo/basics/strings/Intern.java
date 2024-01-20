package org.drogo.basics.strings;

public class Intern {

    public static void main(String[] args) {
        String s1= "Suraj";
        String s2= new String("Suraj");

        System.out.println(s1==s2);

        String s3= s2.intern();
        System.out.println(s1==s3);

    }
}
