package org.drogo.basics.trees.problems.dfs;

import org.drogo.basics.trees.problems.TreeNode;

/*  104. Maximum Depth of Binary Tree
    https://leetcode.com/problems/maximum-depth-of-binary-tree/description/ */
public class MaximumDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.getLeft());
        int right = maxDepth(root.getRight());

        return Math.max(left, right) + 1;

    }
}
