package problem_76;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        int left = 0;
        int right = -1;

        Map<Character, Integer> mapOfT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            int count = mapOfT.getOrDefault(t.charAt(i), 0);
            mapOfT.put(t.charAt(i), count + 1);
        }

        //       lengthOfWindow, leftResult, rightResult
        int[] result = new int[]{1_000_000, 0, 0};

        int formedCharsInWindow = 0; // how many characters have good frequency (freq c in mapOfT = freq c in mapOfWindow)
        int requiredFormedCharsInWindow = mapOfT.keySet().size();

        Map<Character, Integer> mapOfWindow = new HashMap<>();
        while (right < s.length() - 1) {
            // moving right until window will be good (contains all char from t)
            right++;
            mapOfWindow.put(s.charAt(right), mapOfWindow.getOrDefault(s.charAt(right), 0) + 1);

            if (mapOfT.getOrDefault(s.charAt(right), -1).equals(mapOfWindow.get(s.charAt(right)))) {
                formedCharsInWindow++;
            }

            if (formedCharsInWindow == requiredFormedCharsInWindow) {
                if (right - left + 1 < result[0]) {
                    result[0] = right - left + 1;
                    result[1] = left;
                    result[2] = right;
                }
            } else continue;


            // if not continue -> formedCharsInWindow == requiredFormedCharsInWindow (window is good)
            // moving left pointer until window is good
            while (left < right) {
                left++;
                if (mapOfWindow.get(s.charAt(left - 1)).equals(mapOfT.getOrDefault(s.charAt(left - 1), -1))) {
                    mapOfWindow.put(s.charAt(left - 1), mapOfWindow.get(s.charAt(left - 1)) - 1);
                    formedCharsInWindow--;
                    break;
                } else {
                    if (right - left + 1 < result[0]) {
                        result[0] = right - left + 1;
                        result[1] = left;
                        result[2] = right;
                    }
                }
                mapOfWindow.put(s.charAt(left - 1), mapOfWindow.get(s.charAt(left - 1)) - 1);
            }
        }
        if (result[0] == 1000000) return "";
        return s.substring(result[1], result[2] + 1);
    }
}