package org.drogo.basics.trees.implementation;

public class AVLMain {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        for (int i = 0; i < 1000; i++) {
            tree.insert(i);
        }

        System.out.println(tree.height());
    }
}
