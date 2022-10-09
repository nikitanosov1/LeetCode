package problem_653;

import java.util.Objects;

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
    private boolean exist;
    private int target;
    private TreeNode treeRoot;

    public boolean findTarget(TreeNode root, int k) {
        treeRoot = root;
        target = k;
        recursion(treeRoot);
        return exist;
    }

    private void recursion(TreeNode node) {
        if (node == null) return;

        TreeNode pairNode = treeContains(treeRoot, target - node.val);
        if (pairNode != null && pairNode != node) {
            exist = true;
            return;
        }
        recursion(node.left);
        recursion(node.right);
    }

    private TreeNode treeContains(TreeNode node, int x) {
        if (node == null) return null;
        if (node.val == x) return node;
        if (x < node.val) {
            return treeContains(node.left, x);
        } else {
            return treeContains(node.right, x);
        }
    }



    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TreeNode treeNode = (TreeNode) o;
            return val == treeNode.val && Objects.equals(left, treeNode.left) && Objects.equals(right, treeNode.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, left, right);
        }
    }
}