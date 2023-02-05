package problem_438;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) return new ArrayList<>();

        List<Integer> result = new ArrayList<>();

        int[] pFrequency = new int[26];
        for (int i = 0; i < p.length(); ++i) {
            char c = p.charAt(i);
            pFrequency[c - 'a']++;
        }

        // init sliding window
        int goodChars = 0;
        int[] curFrequency = new int[26];
        for (int i = 0; i < 26; ++i) {
            if (pFrequency[i] == curFrequency[i]) {
                goodChars++;
            }
        }

        for (int i = 0; i < p.length(); ++i) {
            char c = s.charAt(i);
            if (curFrequency[c - 'a'] == pFrequency[c - 'a']) {
                goodChars--;
            }
            curFrequency[c - 'a']++;
            if (curFrequency[c - 'a'] == pFrequency[c - 'a']) {
                goodChars++;
            }
        }

        if (goodChars == 26) result.add(0);

        for (int i = p.length(); i < s.length(); ++i) {
            // added new char
            char c = s.charAt(i);
            if (curFrequency[c - 'a'] == pFrequency[c - 'a']) {
                goodChars--;
            }
            curFrequency[c - 'a']++;
            if (curFrequency[c - 'a'] == pFrequency[c - 'a']) {
                goodChars++;
            }

            // remove old char
            c = s.charAt(i - p.length());
            if (curFrequency[c - 'a'] == pFrequency[c - 'a']) {
                goodChars--;
            }
            curFrequency[c - 'a']--;
            if (curFrequency[c - 'a'] == pFrequency[c - 'a']) {
                goodChars++;
            }

            if (goodChars == 26) result.add(i - p.length() + 1);
        }
        return result;
    }
}