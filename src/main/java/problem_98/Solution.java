package problem_98;


class Solution {
    public boolean isValidBST(TreeNode root) {
        return recursionIsValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    private boolean recursionIsValidBST(TreeNode root, Double left, Double right){
        boolean result = (left < root.val) && (root.val < right);
        if (root.left != null) result = result && recursionIsValidBST(root.left, left, (double) root.val);
        if (root.right != null) result = result && recursionIsValidBST(root.right, (double) root.val, right);
        return result;
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
    }
}