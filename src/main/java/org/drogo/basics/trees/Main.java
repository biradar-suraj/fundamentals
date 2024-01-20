package org.drogo.basics.trees;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        BinarySearchTreeExample tree= new BinarySearchTreeExample();
        tree.insert(10);
        tree.insert(5);
        tree.insert(6);
        tree.insert(12);
        int[] nums={7,8,3,4,9};
        tree.insert(nums);
        tree.display();

    }
}
