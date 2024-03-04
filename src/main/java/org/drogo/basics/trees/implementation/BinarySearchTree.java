package org.drogo.basics.trees.implementation;

public class BinarySearchTree {
    private static class Node {
        int value;
        int height;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    public void insert(int value) {
        if (root == null) {
            new Node(value);
        }

        root = insert(value, root);

    }

    private Node insert(int value, Node node) {
        if (node == null) {
            node = new Node(value);
            return node;
        }
        if (value < node.value) {
            node.left = insert(value, node.left);
        }

        if (value > node.value) {
            node.right = insert(value, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right) + 1);
        return node;
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }

        return Math.abs(height(node.left) - height(node.right)) <= 1
                && isBalanced(node.left)
                && isBalanced(node.right);
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void display() {
        display(root, "Root Node: ");
    }

    private void display(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.value);
        display(node.left, "Left of " + node.value + " : ");
        display(node.right, "Right of " + node.value + " : ");
    }

    public void populate(int[] nums) {
        for (int num : nums) {
            this.insert(num);

        }
    }

    public void populateSorted(int[] nums) {
        populateSorted(nums, 0, nums.length);
    }

    private void populateSorted(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;
        this.insert(nums[mid]);
        populateSorted(nums, start, mid);
        populateSorted(nums, mid + 1, end);
    }

    public boolean isBST() {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(Node node, int minValue, int maxValue) {
        if (node == null) {
            return true;
        }

        if (node.value <= minValue || node.value >= maxValue) {
            return false;
        }

        return isBST(node.left, minValue, node.value)
                && isBST(node.right, node.value, maxValue);
    }
}
