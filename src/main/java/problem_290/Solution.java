package problem_290;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] splitS = s.split(" ");
        if (splitS.length != pattern.length()) return false;
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            String word = splitS[i];
            Character character = pattern.charAt(i);
            if (map2.containsKey(word)) {
                if (!map2.get(word).equals(character)) return false;
            } else {
                map2.put(word, character);
            }

            if (map.containsKey(character)) {
                if (!map.get(character).equals(word)) return false;
            } else {
                map.put(character, word);
            }
        }
        return true;
    }
}