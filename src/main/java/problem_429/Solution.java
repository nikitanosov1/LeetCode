package problem_429;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    private Map<Integer, List<Integer>> levelTraversal = new TreeMap<>();

    public List<List<Integer>> levelOrder(Node root) {
        recursion(root, 0);
        return levelTraversal.values().stream().toList();

    }

    private void recursion(Node node, int deep){
        if (node == null) return;
        if (levelTraversal.containsKey(deep)){
            levelTraversal.get(deep).add(node.val);
        } else {
            levelTraversal.put(deep, new ArrayList<>());
            levelTraversal.get(deep).add(node.val);
        }
        if (node.children != null) {
            for (Node child : node.children) {
                recursion(child, deep + 1);
            }
        }
    }

    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}