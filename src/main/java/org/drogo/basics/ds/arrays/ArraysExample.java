package org.drogo.basics.ds.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysExample {

    public static void main(String[] arguments) {

        int[] rollNumbers= new int[5];
        int[] rollNos= {1,2,3,4,5,6};

        int[] ros; //declaration
        ros= new int[5]; //initialisation object is being created in the heap memory


        String[] stringArray= new String[5];
        System.out.println(stringArray[0]);

        for (String string : stringArray) {
            System.out.println(string + " ");

        }

        System.out.println(Arrays.toString(stringArray));

        List a = new ArrayList<>();
        a.add(1,10);

    }
}
