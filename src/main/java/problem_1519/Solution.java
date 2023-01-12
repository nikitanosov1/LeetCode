package problem_1519;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private int[] result;

    private int[] dfs(List<List<Integer>> graph, int root, int parent, String labels) {
        int[] frequencies = new int[26];
        for (Integer x : graph.get(root)) {
            if (x == parent) continue;
            int[] childDfsResult = dfs(graph, x, root, labels);
            for (int i = 0; i < childDfsResult.length; ++i) {
                frequencies[i] += childDfsResult[i];
            }
        }
        frequencies[labels.charAt(root) - 'a']++;
        result[root] = frequencies[labels.charAt(root) - 'a'];
        return frequencies;
    }

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<List<Integer>> graph = new ArrayList<>();
        result = new int[n];
        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<Integer>());
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        dfs(graph, 0, -1, labels);
        return result;
    }
}