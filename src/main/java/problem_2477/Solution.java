package problem_2477;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public long minimumFuelCost(int[][] roads, int seats) {
        // init graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];
            graph.computeIfAbsent(a, value -> new ArrayList<>()).add(b);
            graph.computeIfAbsent(b, value -> new ArrayList<>()).add(a);
        }

        return dfs(0, -1, graph, seats).getKey();
    }

    private Pair<Long, Long> dfs(int node, int parent, Map<Integer, List<Integer>> graph, int seats) {
        Pair<Long, Long> result = new Pair<>(0L, 1L);
        for (int next : graph.getOrDefault(node, new ArrayList<>())) {
            if (next != parent) {
                Pair<Long, Long> litreAndPeople = dfs(next, node, graph, seats);

                Long needCars = litreAndPeople.getValue() / seats;
                if (litreAndPeople.getValue() % seats != 0) needCars++;
                Long newLitres = litreAndPeople.getKey() + needCars;
                result.setKey(result.getKey() + newLitres);

                Long newPeople = litreAndPeople.getValue();
                result.setValue(result.getValue() + newPeople);
            }
        }
        return result;
    }

    public static class Pair<U, V> {
        private U key;
        private V value;

        public Pair(U key, V value) {
            this.key = key;
            this.value = value;
        }

        public U getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setKey(U key) {
            this.key = key;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}