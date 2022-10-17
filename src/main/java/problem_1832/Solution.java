package problem_1832;

import java.util.stream.Collectors;

class Solution {
    public boolean checkIfPangram(String sentence) {
        /*
            SOLUTION IN ONE LINE, BUT WORSE
            return sentence.chars().distinct().count() == 26;
         */
        boolean[] letters = new boolean[26];

        for (int i = 0; i < sentence.length(); ++i) {
            letters[sentence.charAt(i) - 'a'] = true;
        }

        for (int i = 0; i < letters.length; ++i) {
            if (letters[i] == false) {
                return false;
            }
        }
        return true;

    }
}