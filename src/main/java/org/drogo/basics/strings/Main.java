package org.drogo.basics.strings;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        /*String name = "Suraj";
        String name1 = "Suraj";

        if(name==name1){
            System.out.println("both names are equal");
        }

        name="Ramki";

        if(name==name1){
            System.out.println("both names are equal");
        }else {
            System.out.println("both names are not equal");
        }

        String a= new String("Drogo");
        String b= new String("Drogo");

        System.out.println(a==b);
        System.out.println(a.equals(b));
        System.out.println(a.charAt(0));

        System.out.println(Arrays.toString(new int[]{2, 3, 5, 9}));*/



        String suraj= "Suraj Biradar Hello World";

        System.out.println(Arrays.toString(suraj.toCharArray()));
        System.out.println(suraj.toLowerCase());
        System.out.println(suraj);
        System.out.println(suraj.indexOf('a'));
        System.out.println("  Suraj          ".strip());
        System.out.println(Arrays.toString(suraj.split(" ")));

    }
}
