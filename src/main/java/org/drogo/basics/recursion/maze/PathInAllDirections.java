package org.drogo.basics.recursion.maze;

/* Back-tracking */
public class PathInAllDirections {

    static void printAllPaths(int row, int col, String path, boolean[][] maze) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            System.out.println(path);
            return;
        }

        if (!maze[row][col]) {
            return;
        }

        maze[row][col] = false;

        if (row < maze.length - 1) {
            printAllPaths(row + 1, col, path + 'D', maze);
        }
        if (col < maze[0].length - 1) {
            printAllPaths(row, col + 1, path + 'R', maze);
        }
        if (row > 0) {
            printAllPaths(row - 1, col, path + 'U', maze);
        }
        if (col > 0) {
            printAllPaths(row, col - 1, path + 'U', maze);
        }

        maze[row][col] = true;
    }

    public static void main(String[] args) {
        boolean[][] board = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };

        printAllPaths(0, 0, "", board);
    }
}
