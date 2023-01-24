package problem_909;

import java.util.*;

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Map<Integer, List<Integer>> map = new HashMap<>();

        // init graph
        for (int i = 1; i <= n * n; i++) {
            int row = n - 1 - (i - 1) / n;
            int column = ((n - 1 - row) % 2 == 0) ? (i - 1) - (n - 1 - row) * n : n - 1 - ((i - 1) - (n - 1 - row) * n);

            map.put(i, new ArrayList<>());


            for (int j = 1; j < 7; ++j) {
                if (i + j > n * n) break;
                int nextRow = n - 1 - (i + j - 1) / n;
                int nextColumn = ((n - 1 - nextRow) % 2 == 0) ? (i + j - 1) - (n - 1 - nextRow) * n : n - 1 - ((i + j - 1) - (n - 1 - nextRow) * n);
                //System.out.println(i + j + " " + nextRow + " " + nextColumn);
                if (board[nextRow][nextColumn] == -1) {
                    map.get(i).add(i + j);
                } else {
                    map.get(i).add(board[nextRow][nextColumn]);
                }
            }
        }
        System.out.println(map);
        // bfs
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> queueDeep = new LinkedList<>();
        boolean[] isDone = new boolean[n * n + 1];
        queue.add(1);
        queueDeep.add(0);
        int result = -1;
        isDone[1] = true;
        while (!queue.isEmpty()) {
            int x = queue.poll();
            int deep = queueDeep.poll();
            System.out.println("x = " + x + " deep = " + deep);
            if (x == n * n) {
                result = (result == -1) ? deep : Math.min(result, deep);
            }
            for (Integer next : map.get(x)) {
                if (!isDone[next]) {
                    isDone[next] = true;
                    queue.add(next);
                    queueDeep.add(deep + 1);
                }
            }
        }
        return result;
    }
}