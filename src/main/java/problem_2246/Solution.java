package problem_2246;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private Integer maxPath;

    private Pair<Character, Integer> dfs(List<List<Integer>> graph, String s, int root, int parent) {
        Pair<Character, Integer> result = new Pair<>(s.charAt(root), 1);
        for (Integer x : graph.get(root)) {
            if (x == parent) continue;
            Pair<Character, Integer> pair = dfs(graph, s, x, root);
            if (pair.getKey() != s.charAt(root)) { // if chars are different
                // try to merge two maximum ways starting from root
                maxPath = Math.max(maxPath, result.getValue() + pair.getValue());

                // update result (maxPath) with one way
                if (result.getValue() < pair.getValue() + 1) {
                    result.setValue(pair.getValue() + 1);
                }
            }
        }
        maxPath = Math.max(maxPath, result.getValue());
        return result;
    }

    public int longestPath(int[] parent, String s) {
        int n = s.length();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
        }
        for (int i = 1; i < n; ++i) {
            graph.get(i).add(parent[i]);
            graph.get(parent[i]).add(i);
        }
        maxPath = 1;
        dfs(graph, s, 0, -1);
        return maxPath;
    }

    public class Pair<U, V> {
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

        public void setValue(V value) {
            this.value = value;
        }
    }
}