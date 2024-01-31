package org.drogo.basics.recursion.maze;

import java.util.ArrayList;
import java.util.List;

public class MazeProblem {

    static int findPathCount(int row, int col) {
        if (row == 1 || col == 1) {
            return 1;
        }

        int left = findPathCount(row - 1, col);
        int right = findPathCount(row, col - 1);

        return left + right;
    }

    static void printAllPaths(int row, int col, String path) {
        if (row == 1 && col == 1) {
            System.out.println(path);
            return;
        }

        if (row > 1) {
            printAllPaths(row - 1, col, path + 'D');
        }
        if (col > 1) {
            printAllPaths(row, col - 1, path + 'R');
        }
    }

    static List<String> findPathList(int row, int col, String path) {
        List<String> answer = new ArrayList<>();
        if (row == 1 && col == 1) {
            answer.add(path);
            return answer;
        }

        if (row > 1) {
            answer.addAll(findPathList(row - 1, col, path + 'D'));
        }
        if (col > 1) {
            answer.addAll(findPathList(row, col - 1, path + 'R'));
        }
        return answer;
    }

    static List<String> findPathListIncludingDiagonal(int row, int col, String path) {
        List<String> answer = new ArrayList<>();
        if (row == 1 && col == 1) {
            answer.add(path);
            return answer;
        }

        if (row > 1) {
            answer.addAll(findPathListIncludingDiagonal(row - 1, col, path + 'V'));
        }
        if (col > 1) {
            answer.addAll(findPathListIncludingDiagonal(row, col - 1, path + 'H'));
        }
        if (row > 1 && col > 1) {
            answer.addAll(findPathListIncludingDiagonal(row - 1, col - 1, path + 'D'));
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(findPathCount(3, 3));
        printAllPaths(3, 3, "");
        System.out.println(findPathList(3, 3, ""));
        System.out.println(findPathListIncludingDiagonal(3, 3, ""));
    }
}
