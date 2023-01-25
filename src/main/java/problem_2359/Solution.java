package problem_2359;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node1);

        boolean[] isGone = new boolean[n];
        isGone[node1] = true;

        int deep = 0;

        int[] deeps = new int[n];
        for (int i = 0; i < n; ++i) {
            deeps[i] = -1;
        }
        deeps[node1] = 0;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            if (edges[x] != -1 && isGone[edges[x]] == false) {
                isGone[edges[x]] = true;
                queue.add(edges[x]);
                deep++;
                deeps[edges[x]] = deep;
            }
        }

        // for node2
        int resultNodeIndex = 1_000_000_000;
        deep = 0;
        queue.add(node2);
        for (int i = 0; i < n; ++i) {
            isGone[i] = false;
        }
        isGone[node2] = true;

        int minDeep = 1_000_000_000;
        if (deeps[node2] != -1) {
            int maxDeep = Math.max(deeps[node2], deep);
            if (maxDeep < minDeep) {
                minDeep = maxDeep;
                resultNodeIndex = node2;
            }
        }
        while (!queue.isEmpty()) {
            int x = queue.poll();
            if (edges[x] != -1 && isGone[edges[x]] == false) {
                isGone[edges[x]] = true;
                queue.add(edges[x]);
                deep++;
                if (deeps[edges[x]] != -1) {
                    int maxDeep = Math.max(deeps[edges[x]], deep);
                    if (maxDeep == minDeep) {
                        resultNodeIndex = Math.min(resultNodeIndex, edges[x]);
                    } else if (maxDeep < minDeep) {
                        minDeep = maxDeep;
                        resultNodeIndex = edges[x];
                    }
                }
            }
        }
        return (minDeep == 1_000_000_000) ? -1 : resultNodeIndex;
    }
}