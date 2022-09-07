package problem_606;

class Solution {
    public String tree2str(TreeNode root) {
        StringBuilder answer = new StringBuilder(Integer.toString(root.val));
        if (root.left != null) answer
                .append("(")
                .append(tree2str(root.left))
                .append(")");
        else if (root.right != null) answer.append("()");
        if (root.right != null) answer
                .append("(")
                .append(tree2str(root.right))
                .append(")");
        return answer.toString();
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