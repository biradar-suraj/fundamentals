package org.drogo.basics.trees.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*  637. Average of Levels in Binary Tree (BFS)
 *   https://leetcode.com/problems/average-of-levels-in-binary-tree/description/ */
public class AverageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double averageLevel = 0.0;

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                averageLevel += current.val;

                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            averageLevel = averageLevel / levelSize;
            result.add(averageLevel);
        }
        return result;

    }

}
