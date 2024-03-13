package org.drogo.basics.trees.problems.dfs;

import org.drogo.basics.trees.problems.TreeNode;

/*  98. Validate Binary Search Tree
    https://leetcode.com/problems/validate-binary-search-tree/description/ */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);

    }

    private boolean isValidBST(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;

        if (min != null && node.getVal() <= min) {
            return false;
        }

        if (max != null && node.getVal() >= max) {
            return false;
        }

        return isValidBST(node.getLeft(), min, node.getVal())
                && isValidBST(node.getRight(), max, node.getVal());
    }
}
