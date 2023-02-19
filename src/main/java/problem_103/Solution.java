package problem_103;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int maxDeep = -1;

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        evenRecursion(map, root, 0);
        oddRecursion(map, root, 0);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < maxDeep + 1; ++i) {
            result.add(map.get(i));
        }
        return result;
    }

    private void evenRecursion(Map<Integer, LinkedList<Integer>> map, TreeNode node, int deep) {
        if (node == null) {
            return;
        }
        maxDeep = Math.max(maxDeep, deep);
        evenRecursion(map, node.left, deep + 1);

        if (deep % 2 == 0) {
            map.computeIfAbsent(deep, value -> new LinkedList<>()).add(node.val);
        }
        evenRecursion(map, node.right, deep + 1);
    }

    private void oddRecursion(Map<Integer, LinkedList<Integer>> map, TreeNode node, int deep) {
        if (node == null) {
            return;
        }
        oddRecursion(map, node.right, deep + 1);

        if (deep % 2 == 1) {
            map.computeIfAbsent(deep, value -> new LinkedList<>()).add(node.val);
        }
        oddRecursion(map, node.left, deep + 1);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
