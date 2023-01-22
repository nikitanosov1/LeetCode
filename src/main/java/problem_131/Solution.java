package problem_131;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<String>> result;

    private void recursion(String s, int start, List<String> leftPalindromes) {
        for (int i = start; i < s.length(); ++i) {
            // try to find palindrome inclusive to i from start
            boolean isPalindrome = true;
            for (int j = start; j < (i + start + 1) / 2; ++j) {
                if (s.charAt(j) != s.charAt(i - (j - start))) {
                    isPalindrome = false;
                    break;
                }
            }
            if (isPalindrome) {
                if (i == s.length() - 1) {
                    // I am the last palindrome
                    // update result
                    List<String> goodChain = new ArrayList<>(leftPalindromes);
                    goodChain.add(s.substring(start));
                    result.add(goodChain);
                } else {
                    List<String> chain = new ArrayList<>(leftPalindromes);
                    chain.add(s.substring(start, i + 1));
                    recursion(s, i + 1, chain);
                }
            }
        }
    }

    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        recursion(s, 0, new ArrayList<>());
        return result;
    }
}