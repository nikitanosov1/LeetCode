package problem_1626;

import java.util.Arrays;

class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] scoreAndAgePairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            scoreAndAgePairs[i][0] = scores[i];
            scoreAndAgePairs[i][1] = ages[i];
        }

        Arrays.sort(scoreAndAgePairs, (a, b) -> (a[1] == b[1]) ? a[0] - b[0] : a[1] - b[1]);

        int[][] memoDp = new int[n][n];
        Arrays.stream(memoDp).forEach(a -> Arrays.fill(a, -1));
        return recursion(0, -1, scoreAndAgePairs, memoDp);
    }

    private int recursion(int index, int prev, int[][] scoreAndAgePairs, int[][] memoDp) {
        if (index == scoreAndAgePairs.length) return 0;

        // memoization
        if (prev != -1 && memoDp[index][prev] != -1) return memoDp[index][prev];

        if (prev != -1 && scoreAndAgePairs[index][1] > scoreAndAgePairs[prev][1] && scoreAndAgePairs[index][0] < scoreAndAgePairs[prev][0]) {
            int result = recursion(index + 1, prev, scoreAndAgePairs, memoDp);
            memoDp[index][prev] = result;
            return result;
        } else {
            int result = Math.max(recursion(index + 1, prev, scoreAndAgePairs, memoDp), scoreAndAgePairs[index][0] + recursion(index + 1, index, scoreAndAgePairs, memoDp));
            if (prev != -1) memoDp[index][prev] = result;
            return result;
        }
    }
}