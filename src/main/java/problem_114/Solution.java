package problem_114;

import java.util.Objects;
import java.util.Stack;

class Solution {
    private Stack<TreeNode> stack = new Stack<>();

    public void flatten(TreeNode root) {
        if (root == null) return;
        recursion(root);
        TreeNode linkedListRoot = stack.pop();
        while (!stack.isEmpty()){
            stack.peek().left = null;
            stack.peek().right = linkedListRoot;
            linkedListRoot = stack.pop();
        }
    }

    private void recursion(TreeNode currentTreeNode){
        if (currentTreeNode == null) return;
        stack.push(currentTreeNode);
        recursion(currentTreeNode.left);
        recursion(currentTreeNode.right);
    }

    static class TreeNode {
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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}