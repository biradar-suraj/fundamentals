package org.drogo.basics.trees.implementation;

import java.util.Scanner;

public class TreeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        tree.display();

        System.out.println("------Pre-order traversal------");
        tree.preOrder();
        System.out.println("------In-order traversal------");
        tree.inOrder();
        System.out.println("------Post-order traversal------");
        tree.postOrder();
    }
}
