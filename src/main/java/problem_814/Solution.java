package problem_814;

import java.util.Objects;

class Solution {
    public TreeNode pruneTree(TreeNode root) {
        isContainingOne(root);
        if ((root.val == 0) && (root.left == null) && (root.right == null)) return null;
        return root;
    }

    /**
     * @param node - root of the tree.
     * @return true, if tree containing one. Else return false.
     */
    private boolean isContainingOne(TreeNode node){
        if (node == null) return false;
        boolean leftSubTreeNeedSave = isContainingOne(node.left);
        boolean rightSubTreeNeedSave = isContainingOne(node.right);
        if (!leftSubTreeNeedSave) node.left = null;
        if (!rightSubTreeNeedSave) node.right = null;
        return (node.val == 1) ||
                leftSubTreeNeedSave ||
                rightSubTreeNeedSave;
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
