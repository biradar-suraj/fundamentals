package org.drogo.basics.search;

import java.util.Arrays;

public class SortedMatrixSearch {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(Arrays.toString(search(matrix, 7)));

    }

    private static int[] search(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int rowStart = 0;
        int rowEnd = rows - 1;
        int colMid = cols / 2;

        if (rows == 1) {
            return binarySearch(matrix, 0, 0, cols, target);
        }
        while (rowStart < (rowEnd - 1)) {
            int mid = rowStart + (rowEnd - rowStart) / 2;

            if (matrix[mid][colMid] == target) {
                return new int[]{mid, colMid};
            }
            if (matrix[mid][colMid] < target) {
                rowStart = mid;
            } else {
                rowEnd = mid;
            }

        }

        if (matrix[rowStart][colMid] == target) {
            return new int[]{rowStart, colMid};
        }
        if (matrix[rowStart + 1][colMid] == target) {
            return new int[]{rowStart + 1, colMid};
        }

        if (target <= matrix[rowStart][colMid - 1]) {
            return binarySearch(matrix, rowStart, 0, colMid - 1, target);
        }

        if (target >= matrix[rowStart][colMid + 1] &&
                target <= matrix[rowStart][cols - 1]) {
            return binarySearch(matrix, rowStart, colMid + 1, cols - 1, target);
        }

        if (target <= matrix[rowStart + 1][colMid - 1]) {
            return binarySearch(matrix, rowStart + 1, 0, colMid - 1, target);
        } else {
            return binarySearch(matrix, rowStart, colMid + 1, cols - 1, target);
        }


    }

    private static int[] binarySearch(int[][] martrix, int row, int colStart, int colEnd, int target) {
        while (colStart <= colEnd) {
            int mid = colStart + (colEnd - colStart) / 2;

            if (martrix[row][mid] == target) {
                return new int[]{row, mid};
            }
            if (martrix[row][mid] < target) {
                colStart = mid + 1;
            } else {
                colEnd = mid - 1;
            }
        }
        return new int[]{-1, -1};

    }
}
