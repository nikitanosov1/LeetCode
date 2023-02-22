package problem_1011;

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxWeight = -1;
        int sumWeight = 0;
        for (int i = 0; i < weights.length; ++i) {
            maxWeight = Math.max(maxWeight, weights[i]);
            sumWeight += weights[i];
        }

        int l = maxWeight - 1;
        int r = sumWeight;
        int mid;
        while (l + 1 < r) {
            mid = (l + r) / 2;
            if (canShippedForW(mid, days, weights)) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return r;
    }

    private boolean canShippedForW(int w, int days, int[] weights) {
        int curDays = 0;
        int curShipWeight = 0;
        for (int i = 0; i < weights.length; ++i) {
            if (curShipWeight + weights[i] > w) {
                curShipWeight = weights[i];
                curDays++;
            } else {
                curShipWeight += weights[i];
            }
        }
        if (curShipWeight != 0) {
            curDays++;
        }

        if (curDays > days) {
            return false;
        }
        return true;
    }
}