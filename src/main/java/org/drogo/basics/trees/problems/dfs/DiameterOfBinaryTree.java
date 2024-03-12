package org.drogo.basics.trees.problems.dfs;

import org.drogo.basics.trees.problems.TreeNode;

/*  543. Diameter of Binary Tree
    https://leetcode.com/problems/diameter-of-binary-tree/description/ */
public class DiameterOfBinaryTree {
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        calHeight(root);
        return diameter - 1;
    }

    private int calHeight(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = calHeight(node.getLeft());
        int rightHeight = calHeight(node.getRight());

        int d = leftHeight + rightHeight + 1;
        diameter = Math.max(diameter, d);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
