package problem_113;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    private int targSum;
    private final List<List<Integer>> paths = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        targSum = targetSum;
        recursive(root, 0, new LinkedList<Integer>());
        return paths;
    }

    private void recursive(TreeNode node, int currentSum, List<Integer> values) {
        if (node == null) return;
        currentSum += node.val;
        values.add(node.val);
        if (node.left == null && node.right == null & currentSum == targSum) paths.add(new LinkedList<Integer>(values));
        if (node.left != null) {
            recursive(node.left, currentSum, values);
            values.remove(values.size() - 1);
        }
        if (node.right != null) {
            recursive(node.right, currentSum, values);
            values.remove(values.size() - 1);
        }
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
