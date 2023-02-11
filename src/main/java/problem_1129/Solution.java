package problem_1129;

import java.util.*;

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        // init redGraph
        Map<Integer, List<Integer>> redGraph = new HashMap<>();
        for (int[] redEdge : redEdges) {
            int a = redEdge[0];
            int b = redEdge[1];
            redGraph.computeIfAbsent(a, value -> new ArrayList<>()).add(b);
        }

        // init blueGraph
        Map<Integer, List<Integer>> blueGraph = new HashMap<>();
        for (int[] blueEdge : blueEdges) {
            int a = blueEdge[0];
            int b = blueEdge[1];
            blueGraph.computeIfAbsent(a, value -> new ArrayList<>()).add(b);
        }

        // algo
        int[] result = new int[n];
        Arrays.fill(result, -1);

        // int[] = {index_of_top, prev_color,  deep}
        // red = 0 blue = 1
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0});
        queue.add(new int[]{0, 1, 0});

        boolean[] fromRedIsDone = new boolean[n];
        boolean[] fromBlueIsDone = new boolean[n];

        while (!queue.isEmpty()) {
            int[] info = queue.poll();
            int indexOfTop = info[0];
            int prevColor = info[1];
            int deep = info[2];

            // update result
            if (result[indexOfTop] == -1) {
                result[indexOfTop] = deep;
            } else {
                result[indexOfTop] = Math.min(result[indexOfTop], deep);
            }

            // if prev_color = red
            if (prevColor == 0) {
                fromRedIsDone[indexOfTop] = true;
                for (Integer nextTop : blueGraph.getOrDefault(indexOfTop, new ArrayList<>())) {
                    if (!fromBlueIsDone[nextTop]) {
                        queue.add(new int[]{nextTop, 1, deep + 1});
                    }
                }
            } else { // if prev_color = blue
                fromBlueIsDone[indexOfTop] = true;
                for (Integer nextTop : redGraph.getOrDefault(indexOfTop, new ArrayList<>())) {
                    if (!fromRedIsDone[nextTop]) {
                        queue.add(new int[]{nextTop, 0, deep + 1});
                    }
                }
            }
        }
        return result;
    }
}