package org.drogo.basics.trees;

public class BST {

    public static void main(String[] args) {

    }

    static boolean isBST(Node root) {
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static boolean helper(Node root, int min, int max) {
        if (root == null) return true;

        if (root.value < min || root.value > max) return false;

        return helper(root.left, min, root.value - 1)
                && helper(root.right, root.value + 1, max);


    }

}


class Node {
    int value;
    Node left;
    Node right;

}
