package problem_3016;

import java.util.Arrays;

class Solution {
    public int minimumPushes(String word) {
        int[] frequencies = new int[26];
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            ++frequencies[c - 'a'];
        }

        Arrays.sort(frequencies);

        int result = 0;
        for (int i = 0; i < frequencies.length; ++i) {
            result += frequencies[frequencies.length - i - 1] * ((i / 8) + 1);
        }

        return result;
    }
}