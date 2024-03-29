package problem_783;

import java.util.Objects;

class Solution {
    private int minDiff = Integer.MAX_VALUE;
    private Integer prevValue;

    public int minDiffInBST(TreeNode root) {
        recursion(root);
        return minDiff;
    }

    private void recursion(TreeNode root) {
        if (root == null) {
            return;
        }
        recursion(root.left);
        if (prevValue != null) {
            minDiff = Math.min(minDiff, root.val - prevValue);
        }
        prevValue = root.val;
        recursion(root.right);
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