package org.drogo.basics.trees.problems;

import java.util.LinkedList;
import java.util.Queue;

/*  101. Symmetric Tree
    https://leetcode.com/problems/symmetric-tree/description/ */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if (left == null && right == null) continue;

            if (left == null || right == null) return false;

            if (left.val != right.val) return false;

            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }

        return true;

    }

    /* Using recursion*/
    public boolean isSymmetricTree(TreeNode root) {
        return isSymmetricTree(root.left, root.right);
    }

    private boolean isSymmetricTree(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;

        if ((left == null && right != null) || (right == null && left != null)) {
            return false;
        }

        if (left.val != right.val) return false;

        return isSymmetricTree(left.left, right.right)
                && isSymmetricTree(left.right, right.left);
    }
}
