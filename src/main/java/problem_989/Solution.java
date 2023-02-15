package problem_989;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int n = num.length;

        int m = 0;
        int tempK = k;
        while (tempK != 0) {
            tempK /= 10;
            m++;
        }

        LinkedList<Integer> result = new LinkedList<>();
        int toNext = 0;
        for (int i = 0; i < Math.max(n, m); ++i) {
            int curK = k % 10;
            k /= 10;

            int curNum = (n - 1 - i < 0) ? 0 : num[n - 1 - i];

            int curSum = curNum + curK + toNext;
            result.addFirst(curSum % 10);
            toNext = curSum / 10;
        }
        if (toNext != 0) {
            result.addFirst(1);
            return result;
        }
        return result;
    }
}