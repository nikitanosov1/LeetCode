package problem_1162;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;

        // check that we have 1 and 0 cells (not all 0 or all 1)
        int countWaterCell = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) countWaterCell++;
            }
        }
        if (countWaterCell == 0 || countWaterCell == n * n) return -1;

        // BFS
        Queue<int[]> cellQueue = new LinkedList<>();
        Queue<Integer> deepQueue = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    cellQueue.add(new int[]{i, j});
                    deepQueue.add(0);
                }
            }
        }
        int maxDeep = -1;
        while (!cellQueue.isEmpty()) {
            int[] coords = cellQueue.poll();
            int i = coords[0];
            int j = coords[1];
            int deep = deepQueue.poll();
            maxDeep = Math.max(maxDeep, deep);
            // up
            if (i > 0 && grid[i - 1][j] == 0) {
                cellQueue.add(new int[]{i - 1, j});
                deepQueue.add(deep + 1);
                grid[i - 1][j] = -1;
            }
            // down
            if (i < n - 1 && grid[i + 1][j] == 0) {
                cellQueue.add(new int[]{i + 1, j});
                deepQueue.add(deep + 1);
                grid[i + 1][j] = -1;
            }
            // left
            if (j > 0 && grid[i][j - 1] == 0) {
                cellQueue.add(new int[]{i, j - 1});
                deepQueue.add(deep + 1);
                grid[i][j - 1] = -1;
            }
            // right
            if (j < n - 1 && grid[i][j + 1] == 0) {
                cellQueue.add(new int[]{i, j + 1});
                deepQueue.add(deep + 1);
                grid[i][j + 1] = -1;
            }
        }
        return maxDeep;
    }
}