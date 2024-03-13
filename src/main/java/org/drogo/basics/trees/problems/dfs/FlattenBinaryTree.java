package org.drogo.basics.trees.problems.dfs;

import org.drogo.basics.trees.problems.TreeNode;

/*  114. Flatten Binary Tree to Linked List
    https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/ */
public class FlattenBinaryTree {

    /* The "linked list" should be in the same order
       as a pre-order traversal of the binary tree */
    public void flatten(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            if (current.getLeft() != null) {
                TreeNode temp = current.getLeft();
                while (temp.getRight() != null) {
                    temp = temp.getRight();
                }

                temp.setRight(current.getRight());
                current.setRight(current.getLeft());
                current.setLeft(null);
            }
            current = current.getRight();
        }

    }

}
