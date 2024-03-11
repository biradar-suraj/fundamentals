package org.drogo.basics.trees.problems;

/*  993. Cousins in Binary Tree
    https://leetcode.com/problems/cousins-in-binary-tree/description/ */
public class CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx = findNode(root, x);
        TreeNode yy = findNode(root, y);

        return (getLevel(root, xx, 0) == getLevel(root, yy, 0))
                && (!isSiblings(root, xx, yy));

    }

    private TreeNode findNode(TreeNode node, int x) {
        if (node == null) return null;

        if (node.val == x) return node;

        TreeNode n = findNode(node.left, x);
        if (n != null) return n;

        return findNode(node.right, x);
    }

    private boolean isSiblings(TreeNode node, TreeNode x, TreeNode y) {
        if (node == null) return false;

        return (node.left == x && node.right == y)
                || (node.left == y && node.right == x)
                || isSiblings(node.left, x, y)
                || isSiblings(node.right, x, y);
    }

    private int getLevel(TreeNode node, TreeNode x, int level) {
        if (node == null) return 0;

        if (node == x) return level;

        int l = getLevel(node.left, x, level + 1);
        if (l != 0) return l;
        return getLevel(node.right, x, level + 1);


    }
}
