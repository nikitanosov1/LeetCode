package problem_91;

class Solution {
    public int numDecodings(String s) {
        s = "00" + s; // :)
        int[] dp = new int[s.length()];
        dp[1] = 1;

        for (int i = 2; i < s.length(); ++i) {
            int number = (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0');
            if (number > 9 && number < 27) {
                dp[i] += dp[i - 2];
            }
            if (s.charAt(i) != '0') {
                dp[i] += dp[i - 1];
            }
        }
        return dp[s.length() - 1];
    }
}