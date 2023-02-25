package problem_121;

class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int n = prices.length;
        int maxFuturePrice = prices[n - 1];
        for (int i = n - 2; i > -1; --i) {
            maxFuturePrice = Math.max(maxFuturePrice, prices[i]);
            result = Math.max(result, maxFuturePrice - prices[i]);
        }
        return result;
    }
}