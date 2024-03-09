package org.drogo.basics.trees.problems;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*  103. Binary Tree Zigzag Level Order Traversal
    https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/ */
public class ZigZagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reverse = false;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevelList = new ArrayList<>(levelSize);


            for (int i = 0; i < levelSize; i++) {

                if (!reverse) {
                    TreeNode currentNode = queue.pollFirst();
                    currentLevelList.add(currentNode.val);

                    if (currentNode.left != null) {
                        queue.addLast(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        queue.addLast(currentNode.right);
                    }
                } else {
                    TreeNode currentNode = queue.pollLast();
                    currentLevelList.add(currentNode.val);
                    if (currentNode.right != null) {
                        queue.addFirst(currentNode.right);
                    }

                    if (currentNode.left != null) {
                        queue.addFirst(currentNode.left);
                    }

                }
            }
            reverse = !reverse;
            result.add(currentLevelList);
        }
        return result;
    }

}
