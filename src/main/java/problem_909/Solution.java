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
            //System.out.println(i + " " + row + " " + column);

            map.put(i, new ArrayList<>());
            for (int j = 1; j < 7; ++j) {
                if (i + j > n * n) break;
                map.get(i).add(i + j);
            }

            if (board[row][column] != -1) {
                map.get(i).add(board[row][column]);
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
        while (!queue.isEmpty()) {
            System.out.println(queue);
            int x = queue.poll();
            int deep = queueDeep.poll();
            System.out.println("x = " + x);
            isDone[x] = true;
            if (x == n * n) {
                result = Math.min(result, deep);
            }
            for (Integer next : map.get(x)) {
                if (!isDone[next]) {
                    queue.add(next);
                    queueDeep.add(deep + 1);
                }
            }
        }
        return result;
    }
}