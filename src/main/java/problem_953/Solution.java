package problem_953;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public Solution() {
    }

    public boolean isAlienSorted(String[] words, String order) {
        // init
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); ++i) {
            map.put(order.charAt(i), i);
        }

        // algo
        for (int i = 1; i < words.length; ++i) {
            if (compareInOrder(words[i-1], words[i], map) > 0) return false;
        }
        return true;
    }

    public int compareInOrder(String s1, String s2, Map<Character, Integer> map) {
        for (int i = 0; i < Math.min(s1.length(), s2.length()); ++i) {
            int result = Integer.compare(map.get(s1.charAt(i)), map.get(s2.charAt(i)));
            if (result != 0) return result;
        }
        if (s1.length() < s2.length()) return -1;
        if (s1.length() > s2.length()) return 1;
        return 0;
    }
}