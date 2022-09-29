package problem_49;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    private int[] frequency = new int[26];

    private String stringSort(String str) {
        char[] strInChars = str.toCharArray();
        for (char c : strInChars) {
            ++frequency[c - 'a'];
        }
        int insertIndex = 0;
        for (int i = 0; i < frequency.length; ++i) {
            while (frequency[i] > 0) {
                strInChars[insertIndex] = (char)('a' + i);
                --frequency[i];
                ++insertIndex;
            }
        }
        return new String(strInChars);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String sortedStr = stringSort(str);
            List<String> temp = map.getOrDefault(sortedStr, new ArrayList<String>());
            temp.add(str);
            map.put(sortedStr, temp);
        }
        return map.values().stream().
                toList();
    }
}
