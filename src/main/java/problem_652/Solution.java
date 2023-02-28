package problem_652;

import java.util.*;

class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, int[]> map = new HashMap<>();
        // int[] consists of int[0] (id) and int[1] (frequency count)
        List<TreeNode> result = new ArrayList<>();
        recursion(root, map, result);
        return result;
    }

    private int recursion(TreeNode node, Map<String, int[]> map, List<TreeNode> result) {
        if (node == null) {
            return 0;
        }

        String triplet = recursion(node.left, map, result) + " " + node.val + " " + recursion(node.right, map, result);
        if (map.containsKey(triplet)) {
            if (map.get(triplet)[1] == 0) {
                result.add(node);
                map.put(triplet, new int[]{map.get(triplet)[0], 1});
            }
            return map.get(triplet)[0];
        } else {
            int newId = map.size() + 1;
            map.put(triplet, new int[]{newId, 0});
            return newId;
        }
    }

    private static class TreeNode {
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