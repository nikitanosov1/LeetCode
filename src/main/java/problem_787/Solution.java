package problem_787;

import java.util.*;

public class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // init graph
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] flight : flights) {
            adj.computeIfAbsent(flight[0], value -> new ArrayList<>()).add(new int[] {flight[1], flight[2]});
        }

        // algo
        // {distance_from_src, cur_node, stops_from_src}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, src, 0});

        // optimization (memoization)
        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);

        while (!pq.isEmpty()) {
            int[] info = pq.poll();
            int distanceFromSrc = info[0];
            int currNode = info[1];
            int stopsFromSrc = info[2];

            if (stopsFromSrc - 1 > k || stopsFromSrc > stops[currNode]) {
                continue;
            }
            stops[currNode] = stopsFromSrc;

            if (currNode == dst) {
                return distanceFromSrc;
            }

            // the following nodes from curNode don't exist
            if (!adj.containsKey(currNode)) {
                continue;
            }

            for (int[] next : adj.get(currNode)) {
                pq.offer(new int[]{distanceFromSrc + next[1], next[0], stopsFromSrc + 1});
            }
        }
        return -1;
    }
}
