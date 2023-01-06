package problem_1833;

import java.util.Arrays;

class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        // it can be solved by count sorting, but in my opinion this solution is better
        int result = 0;
        for (int i = 0; i < costs.length; ++i) {
            if (costs[i] > coins) break;
            result++;
            coins -= costs[i];
        }
        return result;
    }
}