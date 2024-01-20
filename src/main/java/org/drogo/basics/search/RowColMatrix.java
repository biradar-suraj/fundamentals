package org.drogo.basics.search;

import java.util.Arrays;

public class RowColMatrix {
    public static void main(String[] args) {
        int[][] matrix={
                {10,20,30,40},
                {15,25,35,45},
                {28,29,37,49},
                {33,34,38,50}
        };
        int target= 37;
        System.out.println(Arrays.toString(search(matrix, target)));

    }

    private static int[] search(int[][] matrix, int target) {
        int[] result = {-1, -1};
        int row = 0;
        int col = matrix.length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                result= new int[]{row, col};
                return result;
            }
            if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return result;

    }
}
