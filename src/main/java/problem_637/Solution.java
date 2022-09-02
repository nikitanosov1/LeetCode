package problem_637;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<Double> levelSums = new ArrayList<>();
    private List<Integer> levelCount = new ArrayList<>();

    public List<Double> averageOfLevels(TreeNode root) {
        recursive(root, 1);
        List<Double> levelAverage = new ArrayList<>();
        for (int i = 0; i < levelCount.size(); i++) {
            levelAverage.add(levelSums.get(i) / levelCount.get(i));
        }
        return levelAverage;
    }

    private void recursive(TreeNode node, int deep){
        if (node == null) return;
        if (deep > levelCount.size()){
            levelSums.add((double) node.val);
            levelCount.add(1);
        } else {
            levelSums.set(deep - 1, levelSums.get(deep - 1) + node.val);
            levelCount.set(deep - 1, levelCount.get(deep - 1) + 1);
        }
        recursive(node.left, deep + 1);
        recursive(node.right, deep + 1);
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
