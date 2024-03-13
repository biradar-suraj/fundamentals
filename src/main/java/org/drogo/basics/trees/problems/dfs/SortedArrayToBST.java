package org.drogo.basics.trees.problems.dfs;

import org.drogo.basics.trees.problems.TreeNode;

/*  104. Maximum Depth of Binary Tree
    https://leetcode.com/problems/maximum-depth-of-binary-tree/description/ */
public class SortedArrayToBST {
    public static TreeNode sortedArrayToBST(int[] nums) {
        return createBST(nums, 0, nums.length - 1);
    }

    private static TreeNode createBST(int[] nums, int start, int end) {
        if (start > end) return null;

        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.setLeft(createBST(nums, start, mid - 1));
        root.setRight(createBST(nums, mid + 1, end));

        return root;

    }

}
