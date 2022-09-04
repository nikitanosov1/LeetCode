package problem_987;

import java.util.*;

class Solution {
    private Map<Integer, Map<Integer, List<Integer>>> map = new TreeMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        recursion(root, 0, 0);
        List<List<Integer>> result = new ArrayList<>();
        for (Integer col : map.keySet()) {
            List<Integer> colVals = new ArrayList<>();
            for (Integer row : map.get(col).keySet()) {
                colVals.addAll(map.get(col).get(row).stream().sorted().toList());
            }
            result.add(colVals);
        }
        return result;
    }

    // row = deep
    private void recursion(TreeNode node, int row, int col){
        if (node == null) return;
        if (map.containsKey(col)){
            if (map.get(col).containsKey(row)){
                map.get(col).get(row).add(node.val);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(node.val);
                map.get(col).put(row, list);
            }
        } else {
            Map<Integer, List<Integer>> mapForNewCol = new TreeMap<>();
            mapForNewCol.put(row, new ArrayList<>());
            mapForNewCol.get(row).add(node.val);
            map.put(col, mapForNewCol);
        }
        recursion(node.left, row + 1, col - 1);
        recursion(node.right, row + 1, col + 1);
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