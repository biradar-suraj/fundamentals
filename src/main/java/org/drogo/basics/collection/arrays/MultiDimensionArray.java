package org.drogo.basics.collection.arrays;


import java.util.Arrays;
import java.util.Scanner;

public class MultiDimensionArray {
    public static void main(String[] args) {
        int[] arr = new int[5];

        int[][] matrix = new int[3][];//mandatory to declare the number of rows
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] array = {
                {1, 2, 3},
                {4, 5},
                {6, 7, 8, 9}
        };

        int[][] arr1= new int[3][3];
        System.out.println(arr1.length); // no of rows

        //taking input for 2D array
        Scanner in = new Scanner(System.in);
        for (int row = 0; row < array.length; row++) {
            // now for each col in every row
            for (int col = 0; col < arr1[row].length; col++) {
                arr1[row][col]=in.nextInt();

            }
        }

        for (int row = 0; row < arr1.length; row++) {
            for (int col = 0; col < arr1[row].length; col++) {
                System.out.print(arr1[row][col]+" ");

            }
            System.out.println();
        }

        for (int row = 0; row < arr1.length; row++) {
            System.out.println(Arrays.toString(arr1[row]));
        }

        for (int[] a: arr1){
            System.out.println(Arrays.toString(a));
        }

    }
}
