package problem_45;

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        dp[n - 1] = 0;

        for (int i = n - 2; i > -1; --i) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= nums[i]; ++j) {
                if (i + j >= n) break;
                if (dp[i + j] == Integer.MAX_VALUE) continue;
                min = Math.min(min, 1 + dp[i + j]);
            }
            dp[i] = min;
        }

        return dp[0];
    }
}
