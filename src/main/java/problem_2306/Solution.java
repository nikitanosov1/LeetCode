package problem_2306;

import java.util.*;

class Solution {
    public long distinctNames(String[] ideas) {
        // group ideas by first char
        Map<Character, Set<String>> map = new HashMap<>();
        for (String idea : ideas) {
            map.computeIfAbsent(idea.charAt(0), value -> new HashSet<>()).add(idea.substring(1));
        }

        long result = 0;
        for (Character charA : map.keySet()) {
            for (Character charB : map.keySet()) {
                if (charA <= charB) continue;

                long countOfMutualSuffixes = 0L;
                for (String sufA : map.get(charA)) {
                    if (map.get(charB).contains(sufA)) {
                        countOfMutualSuffixes++;
                    }
                }

                result += 2L * (map.get(charA).size() - countOfMutualSuffixes) * (map.get(charB).size() - countOfMutualSuffixes);
            }
        }
        return result;

        /*
        O(n^2) -> Time Limit Exceeded

        int n = ideas.length;
        Set<String> ideasSet = new HashSet<>();
        for (String idea : ideas) {
            ideasSet.add(idea);
        }

        Set<String> result = new HashSet<>();
        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                String s1 = ideas[j].charAt(0) + ideas[i].substring(1);
                String s2 = ideas[i].charAt(0) + ideas[j].substring(1);

                if (!ideasSet.contains(s1) && !ideasSet.contains(s2)) {
                    result.add(s1 + " " + s2);
                    result.add(s2 + " " + s1);
                }
            }
        }
        return result.size();
        */
    }
}