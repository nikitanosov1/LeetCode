package problem_3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> hashMap = new HashMap<>();
        int maxLength = 0;
        int startSequence = -1;
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (hashMap.containsKey(currentChar)) {
                startSequence = Math.max(startSequence, hashMap.get(currentChar));
            }
            maxLength = Math.max(maxLength, i - startSequence);
            hashMap.put(currentChar, i);
        }
        return maxLength;
    }
}