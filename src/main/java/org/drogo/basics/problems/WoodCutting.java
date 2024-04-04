package org.drogo.basics.problems;

public class WoodCutting {

    public static int machineHeight(int[] ht, int b) {
        int max = 0;
        for (int j : ht) {
            if (j > max) {
                max = j;
            }
        }

        int low = 0;
        int high = max;
        int mid = 0;

        while (low <= high) {
            mid = (low + high) / 2;
            int wc = findWoodCount(ht, mid);
            if (wc == b || low == mid) {
                return mid;
            } else if (wc > b) {
                low = mid;

            } else {
                high = mid;
            }
        }

        return -1;
    }

    private static int findWoodCount(int[] ht, int mid) {
        int wc = 0;

        for (int j : ht) {
            if (j > mid) {
                wc = wc + (j - mid);
            }
        }

        return wc;
    }

    public static void main(String[] args) {
        int[] h = {20, 15, 10, 17};
        int b = 7;
        System.out.println(machineHeight(h, b));
    }
}
