package problem_1382;
/*
 * @author Nikita Nosov
 * Date: 2/9/2026
 */

import java.util.ArrayList;
import java.util.List;

class Solution {
    public TreeNode balanceBST(TreeNode root) {
        // root точно не null
        List<TreeNode> sortedNodes = getSortedNodes(root); // O(N)

        return buildBalanceBST(sortedNodes, 0, sortedNodes.size() - 1); // O(N)
    }

    private TreeNode buildBalanceBST(List<TreeNode> sortedNodes, int i, int j) {
        if (j < i) {
            return null;
        }
        int mid = (i + j) / 2;
        TreeNode root = sortedNodes.get(mid);
        root.left = buildBalanceBST(sortedNodes, i, mid - 1);
        root.right = buildBalanceBST(sortedNodes, mid + 1, j);
        return root;
    }

    private List<TreeNode> getSortedNodes(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        dfs(nodes, root);
        return nodes;
    }

    private void dfs(List<TreeNode> nodes, TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(nodes, root.left);
        nodes.add(root);
        dfs(nodes, root.right);
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
