package org.drogo.basics.trees;

import java.util.Scanner;

public class BinaryTreeExample {

    private Node root;

    public void insert(Scanner scanner) {
        System.out.println("Insert the root node");
        int value = scanner.nextInt();
        root = new Node(value);
        insertHelper(scanner, root);

    }

    private void insertHelper(Scanner scanner, Node node) {
        System.out.println("Insert left of " + node.value);
        boolean left = scanner.nextBoolean();
        if (left) {
            System.out.println("Enter the value for the left of " + node.value);
            int value = scanner.nextInt();
            node.left = new Node(value);
            insertHelper(scanner, node.left);
        }

        System.out.println("Insert right of " + node.value);
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.println("Enter the value for right of " + node.value);
            int value = scanner.nextInt();
            node.right = new Node(value);
            insertHelper(scanner, node.right);
        }


    }

    public void display() {
        displayHelper(root, "");
    }

    private void displayHelper(Node node, String indent) {
        if (root == null) return;
        System.out.println(indent + node.value);
        displayHelper(node.left, indent + "\t");
        displayHelper(node.right, indent + "\t");
    }

    private class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}
