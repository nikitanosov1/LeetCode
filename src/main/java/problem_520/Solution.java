package problem_520;

class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.length() == 1) return true;
        if (word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') {
            if (word.charAt(1) >= 'A' && word.charAt(1) <= 'Z') {
                // All letters in this word are capitals, like "USA".
                for (int i = 2; i < word.length(); ++i) {
                    if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') return false;
                }
            } else {
                // Only the first letter in this word is capital, like "Google".
                for (int i = 2; i < word.length(); ++i) {
                    if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') return false;
                }
            }
        } else {
            // All letters in this word are not capitals, like "leetcode".
            for (int i = 1; i < word.length(); ++i) {
                if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') return false;
            }
        }
        return true;
    }
}