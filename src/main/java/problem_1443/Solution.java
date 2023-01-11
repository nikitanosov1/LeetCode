package problem_1443;

import java.util.ArrayList;
import java.util.List;

class Solution {
    /**
     * @param graph - all graph
     * @param root - current top
     * @param parent - parent of this root
     * @param hasApple - List by condition
     * @return -1, if no apple among all children and root top
     *          totalTime, if there are apples among the children
     */
    private int dfs(List<List<Integer>> graph, int root, int parent, List<Boolean> hasApple) {
        int totalTime = 0;
        for (Integer x : graph.get(root)) {
            if (x == parent) continue;
            int childTime = dfs(graph, x, root, hasApple);
            if (childTime >= 0) {
                totalTime += childTime + 2;
            }
        }

        if (totalTime == 0 && !hasApple.get(root)) {
            return -1;
        }
        return totalTime;
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; ++i){
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // DFS
        int minimumTime = dfs(graph, 0, -1, hasApple);
        if (minimumTime == -1) {
            minimumTime = 0;
        }
        return minimumTime;
    }
}
