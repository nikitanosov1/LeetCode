package problem_567;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        // calc charFrequncy in s1
        int[] charFrequncy = new int[26];
        for (int i = 0; i < s1.length(); ++i) {
            ++charFrequncy[s1.charAt(i) - 'a'];
        }

        int[] currentCharFrequncy = new int[26];
        int currentGoodChars = 0;
        for (int i = 0; i < 26; ++i) {
            if (currentCharFrequncy[i] == charFrequncy[i]) {
                ++currentGoodChars;
            }
        }
        // we will return true if currentGoodChars == 26

        // init fill window
        for (int i = 0; i < s1.length(); ++i) {
            char c = s2.charAt(i);
            if (currentCharFrequncy[c - 'a'] == charFrequncy[c - 'a']) {
                --currentGoodChars;
            }
            ++currentCharFrequncy[c - 'a'];
            if (currentCharFrequncy[c - 'a'] == charFrequncy[c - 'a']) {
                ++currentGoodChars;
            }
        }
        if (currentGoodChars == 26) return true;

        // moving the window
        for (int i = s1.length(); i < s2.length(); ++i) {
            char oldChar = s2.charAt(i - s1.length());
            char newChar = s2.charAt(i);

            // add newChar to window
            if (currentCharFrequncy[newChar - 'a'] == charFrequncy[newChar - 'a']) {
                currentGoodChars--;
            }
            ++currentCharFrequncy[newChar - 'a'];
            if (currentCharFrequncy[newChar - 'a'] == charFrequncy[newChar - 'a']) {
                currentGoodChars++;
            }

            // remove oldChar from window
            if (currentCharFrequncy[oldChar - 'a'] == charFrequncy[oldChar - 'a']) {
                currentGoodChars--;
            }
            --currentCharFrequncy[oldChar - 'a'];
            if (currentCharFrequncy[oldChar - 'a'] == charFrequncy[oldChar - 'a']) {
                currentGoodChars++;
            }


            if (currentGoodChars == 26) return true;
        }
        return false;
    }
}