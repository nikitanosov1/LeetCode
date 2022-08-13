package problem_30;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
    private int wordLength;
    private int countOfWords;
    private int substringLength;
    private final Map<String, Integer> hashMap = new HashMap<>();

    private Integer check(String s, int startIndex){
        Map<String, Integer> remainedWords = new HashMap<>(hashMap);
        for (int i = startIndex; i < startIndex + substringLength; i += wordLength) {
            String currentWord = s.substring(i, i + wordLength);
            if (!remainedWords.containsKey(currentWord)) return null;
            // currentWord exists in remainedWords
            Integer remainCount = remainedWords.get(currentWord);
            if (remainCount == 0) return null;
            remainedWords.put(currentWord, remainCount - 1);
        }
        return startIndex;
    }

    public List<Integer> findSubstring(String s, String[] words) {
        // init
        List<Integer> answer = new LinkedList<>();
        wordLength = words[0].length();
        countOfWords = words.length;
        substringLength = words[0].length() * words.length;
        // filling the hashmap
        for (String word : words) {
            hashMap.put(word, hashMap.getOrDefault(word, 0) + 1);
        }
        // algo
        for (int i = 0; i < s.length() - substringLength + 1; i++) {
            Integer approachIndex = check(s, i);
            if (approachIndex != null) answer.add(approachIndex);
        }
        return answer;
    }
}