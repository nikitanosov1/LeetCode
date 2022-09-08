package problem_94;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        recursion(root);
        return result;
    }

    private void recursion(TreeNode treeNode){
        if (treeNode == null) return;
        recursion(treeNode.left);
        result.add(treeNode.val);
        recursion(treeNode.right);
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