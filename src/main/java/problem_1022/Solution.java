package problem_1022;
/*
 * @author Nikita Nosov
 * Date: 2/24/2026
 */

class Solution {
    private int result = 0;

    public int sumRootToLeaf(TreeNode root) {
        dfs(0, root);
        return result;
    }

    private void dfs(int curValue, TreeNode node) {
        curValue <<= 1;
        curValue |= node.val;
        if (node.left == null && node.right == null) {
            result += curValue;
        }
        if (node.left != null) {
            dfs(curValue, node.left);
        }
        if (node.right != null) {
            dfs(curValue, node.right);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
