package org.drogo.basics.trees.implementation;

import java.util.Scanner;

public class BinaryTree {
    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    public void populate(Scanner scanner) {
        System.out.println("Enter the root node: ");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(root, scanner);
    }

    private void populate(Node node, Scanner scanner) {
        System.out.println("Do you want to insert left of: " + node.value);
        boolean left = scanner.nextBoolean();
        if (left) {
            System.out.println("Enter tha value for the left of " + node.value);
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(node.left, scanner);
        }

        System.out.println("Do you want to insert right of: " + node.value);
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.println("Enter the value for the right of " + node.value);
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(node.right, scanner);
        }
    }

    public void display() {
        display(root, " ");
    }

    private void display(Node node, String indent) {
        if (node == null) {
            return;
        }
        System.out.println(indent + node.value);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
    }

    /* Tree traversals
     * Pre-order
     * In-order
     * Post-order */

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) return;

        System.out.println(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) return;

        inOrder(node.left);
        System.out.println(node.value + " ");
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value + " ");

    }
}
