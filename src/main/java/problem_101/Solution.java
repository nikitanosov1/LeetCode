package problem_101;

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
    public boolean isSymmetric(TreeNode root) {
        return root == null || isMirror(root.left, root.right);
    }
    boolean isMirror(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;

        if (node1 == null || node2 == null) return false;

        if (node1.val != node2.val) return false;
        return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
    }
    /*
    My first solution O(n) memory

    private LinkedList<Integer> queue = new LinkedList<>();
    private boolean isSymmetric = true;

    public boolean isSymmetric(TreeNode root) {
        leftRecursion(root.left);
        rightRecursion(root.right);
        return isSymmetric;
    }

    private void leftRecursion(TreeNode node) {
        if (node == null) {
            queue.add(1_000_000);
            return;
        }
        queue.add(node.val);
        leftRecursion(node.left);
        leftRecursion(node.right);
    }

    private void rightRecursion(TreeNode node) {
        if (node == null) {
            if (queue.isEmpty() || queue.poll() != 1_000_000) {
                isSymmetric = false;
            }
            return;
        } else {
            if (queue.isEmpty() || queue.poll() != node.val) {
                isSymmetric = false;
                return;
            }
        }
        rightRecursion(node.right);
        rightRecursion(node.left);
    }
    */







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