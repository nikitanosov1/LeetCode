package problem_472;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    private Set<String> set = new HashSet<>();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        // init
        for (String s : words) {
            set.add(s);
        }

        List<String> result = new ArrayList<>();
        // algo
        for (String s : words) {
            int count = getCountOfWords(s);
            if (count > 1) {
                result.add(s);
            }
        }
        return result;
    }

    public int getCountOfWords(String s) {
        int maxCountOfWords = -1;

        for (int i = 0; i < s.length() - 1; ++i) {
            if (set.contains(s.substring(0, i + 1))) {
                int suffixCount = getCountOfWords(s.substring(i + 1));
                if (suffixCount == -1) {
                    continue;
                }
                maxCountOfWords = Math.max(maxCountOfWords, 1 + getCountOfWords(s.substring(i + 1)));
            }
        }
        if (maxCountOfWords != -1) return maxCountOfWords;
        if (set.contains(s)) {
            return 1;
        }
        return -1;
    }
}