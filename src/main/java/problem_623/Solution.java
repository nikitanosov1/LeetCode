package problem_623;

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
    private int value;

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        value = val;
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(value, root, null);
            return newRoot;
        }
        recursion(root, depth);
        return root;

    }

    private void recursion(TreeNode node, int depth) {
        if (node == null) return;
        if (depth == 2) {
            TreeNode leftNode = new TreeNode(value, node.left, null);
            TreeNode rightNode = new TreeNode(value, null, node.right);
            node.left = leftNode;
            node.right = rightNode;
            return;
        }
        recursion(node.left, depth - 1);
        recursion(node.right, depth - 1);
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
