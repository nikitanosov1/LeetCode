package problem_1155;

class Solution {
    private final int MOD = (int)(1e9 + 7);
    private int[][] dp;

    public int numRollsToTarget(int n, int k, int target) {
        dp = new int[n + 1][target + 1];
        for (int i = 0; i < target + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (j == 1 && i > 1 && i < k + 1) {
                    dp[j][i] = 1; // если один кубик
                    continue;
                }
                if (i == j) {
                    dp[j][i] = 1;
                    continue;
                }
                for (int l = 1; l < k + 1; l++) {
                    if (i - l > -1) dp[j][i] = (dp[j][i] + dp[j - 1][i - l]) % MOD;
                }
            }
        }
        return dp[n][target];
    }
}