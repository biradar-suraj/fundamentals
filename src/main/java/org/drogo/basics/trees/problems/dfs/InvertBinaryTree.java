package org.drogo.basics.trees.problems.dfs;

import org.drogo.basics.trees.problems.TreeNode;

/*  226. Invert Binary Tree
    https://leetcode.com/problems/invert-binary-tree/description/ */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode left = invertTree(root.getLeft());
        TreeNode right = invertTree(root.getRight());

        root.setLeft(right);
        root.setRight(left);

        return root;

    }
}
