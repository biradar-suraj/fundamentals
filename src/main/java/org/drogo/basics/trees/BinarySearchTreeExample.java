package org.drogo.basics.trees;

public class BinarySearchTreeExample {

    private Node root;

    public int height(Node node) {
        if (node == null) return -1;
        return node.height;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(int value) {
        if (root == null) {
            new Node(value);
        }
        root=insertHelper(value,root);

    }

    private Node insertHelper(int value, Node node) {
        if (node == null) {
            return new Node(value);
        }
        if (value < node.value) {
            node.left = insertHelper(value, node.left);
        }
        if (value > node.value) {
            node.right = insertHelper(value, node.right);
        }

        node.height= Math.max(height(node.left),height(node.right))+1;
        return node;
    }

    public void insert(int[] nums){
        for(int num:nums){
            insert(num);
        }
    }

    public boolean balanced(Node node){
        if(node==null) return true;
        return Math.abs(height(node.left) - height(node.right)) <= 1
                && balanced(node.left) && balanced(node.right);
    }

    public void display() {
        displayHelper(root,"RootNode:");

    }

    private void displayHelper(Node node, String details) {
        if(node==null){
            return;
        }
        System.out.println(details+node.value);
        displayHelper(node.left,"Left of "+node.value+":");
        displayHelper(node.right,"Right of "+node.value+":");
    }


    private static class Node {
        int value;
        int height;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}
