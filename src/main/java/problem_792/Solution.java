package problem_792;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int result = 0;
        Map<Character, Queue<String>> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), new LinkedList<>());
        }

        for (String word : words) {
            char startChar = word.charAt(0);
            if (map.containsKey(startChar)){
                map.get(startChar).add(word);
            }
        }


        for (int i = 0; i < s.length(); i++) {
            char startChar = s.charAt(i);
            Queue<String> queue = map.get(startChar);
            int size = queue.size(); // fixed size, we will append new elem
            for (int j = 0; j < size; j++) {
                String elem = queue.poll();
                if (elem.length() == 1) ++result;
                else{
                    char newStartChar = elem.charAt(1);
                    if (map.containsKey(newStartChar)){
                        map.get(newStartChar).add(elem.substring(1));
                    }
                }
            }
        }
        return result;
    }
}