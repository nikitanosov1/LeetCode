package problem_692;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 0);
            }
        }

        List<Map.Entry<String, Integer>> list = map.entrySet().stream().collect(Collectors.toList());
        Collections.sort(list, new Comparator<>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() < o2.getValue()) return 1;
                if (o1.getValue() > o2.getValue()) return -1;
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; ++i) {
            result.add(list.get(i).getKey());
        }
        return result;
    }
    
    private static class Pair {
        private String key;
        private Integer value;

        public Pair(String key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }
    }
}
