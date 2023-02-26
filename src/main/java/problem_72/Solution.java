package problem_72;

import java.util.Arrays;

class Solution {
    public int minDistance(String word1, String word2) {
        int[][] memo = new int[word1.length()][word2.length()];
        Arrays.stream(memo).forEach(arr -> Arrays.fill(arr, -1));

        return minDistanceRecursive(word1, word2, word1.length() - 1, word2.length() - 1, memo);
    }

    private int minDistanceRecursive(String word1, String word2, int index1, int index2, int[][] memo) {
        if (index1 == -1) {
            return index2 + 1;
        }
        if (index2 == -1) {
            return index1 + 1;
        }

        if (memo[index1][index2] != -1) {
            return memo[index1][index2];
        }

        if (word1.charAt(index1) == word2.charAt(index2)) {
            memo[index1][index2] = minDistanceRecursive(word1, word2, index1 - 1, index2 - 1, memo);
            return memo[index1][index2];
        }
        memo[index1][index2] = Math.min(
                minDistanceRecursive(word1, word2, index1, index2 - 1, memo), // if insert
                Math.min(
                        minDistanceRecursive(word1, word2, index1 - 1, index2, memo), // if delete
                        minDistanceRecursive(word1, word2, index1 - 1, index2 - 1, memo) // if replace
                )
        ) + 1;
        return memo[index1][index2];
    }

    /*
    TL: O(3^(max(len1, len2)))
    Brute force

    public int minDistance(String word1, String word2) {
        return minDistanceRecursive(word1, word2, word1.length() - 1, word2.length() - 1);
    }

    private int minDistanceRecursive(String word1, String word2, int index1, int index2) {
        if (index1 == -1) {
            return index2 + 1;
        }
        if (index2 == -1) {
            return index1 + 1;
        }
        if (word1.charAt(index1) == word2.charAt(index2)) {
            return minDistanceRecursive(word1, word2, index1 - 1, index2 - 1);
        }
        return Math.min(
                minDistanceRecursive(word1, word2, index1, index2 - 1), // if insert
                Math.min(
                        minDistanceRecursive(word1, word2, index1 - 1, index2), // if delete
                        minDistanceRecursive(word1, word2, index1 - 1, index2 - 1) // if replace
                )
        ) + 1;
    }
    */
}