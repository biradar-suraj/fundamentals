package org.drogo.basics.trees.implementation;

public class SegmentTree {
    private static class Node {
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

        public Node(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

    Node root;

    public SegmentTree(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty.");
        }
        this.root = constructTree(arr, 0, arr.length - 1);
    }

    private Node constructTree(int[] arr, int start, int end) {
        if (start > end) return null;

        Node node = new Node(start, end);

        if (start == end) {
            //leaf node

            node.data = arr[start];
            return node;
        } else {
            int mid = start + (end - start) / 2;

            node.left = constructTree(arr, start, mid);
            node.right = constructTree(arr, mid + 1, end);
            node.data = node.left.data + node.right.data;
        }

        return node;
    }


    public int query(int start, int end) {
        return query(root, start, end);
    }

    private int query(Node node, int start, int end) {
        if (node == null) return 0;

        if (start <= node.startInterval && end >= node.endInterval) {
            return node.data;
        }
        if (end < node.startInterval || start > node.endInterval) {
            return 0;
        }
        return query(node.left, start, end) + query(node.right, start, end);


    }

    public void update(int index, int value) {
        update(root, index, value);

    }

    private void update(Node node, int index, int value) {
        if (node == null) return;

        if (node.startInterval == node.endInterval) {
            node.data = value;
        } else {
            int mid = (node.startInterval + node.endInterval) / 2;
            if (index <= mid) {
                update(node.left, index, value);
            } else {
                update(node.right, index, value);
            }
            node.data = node.left.data + node.right.data;
        }
    }

    public void display() {
        display(this.root, 0);
    }

    private void display(Node node, int level) {
        if (node == null) {
            return;
        }

        String str = String.format("Level %d: Interval=[%d-%d] and data: %d",
                level, node.startInterval, node.endInterval, node.data);
        System.out.println(str);

        if (node.left != null) {
            display(node.left, level + 1);
        }

        if (node.right != null) {
            display(node.right, level + 1);
        }
    }

}
