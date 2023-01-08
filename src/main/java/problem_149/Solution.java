package problem_149;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxPoints(int[][] points) {
        // O(n^2) solution
        int n = points.length;
        int maxPoints = 1;
        for (int i = 0; i < n; ++i) {
            Map<Double, Integer> map = new HashMap<>();
            for (int j = 0; j < n; ++j) {
                if (j != i) {
                    // calc arctg by y and x of vector
                    double angle = Math.atan2(points[j][1] - points[i][1], points[j][0] - points[i][0]);
                    map.put(angle, map.getOrDefault(angle, 1) + 1);
                }
            }
            for (Integer count : map.values()) {
                maxPoints = Math.max(maxPoints, count);
            }
        }
        return maxPoints;

        /* O(n^3) solution

        int n = points.length;
        int maxPoints = 1;
        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int currentPoints = 2;
                for (int k = 0; k < n; ++k) {
                    if (k != i && k != j) {
                        if ((points[k][1] - points[i][1]) * (points[j][0] - points[i][0]) ==
                                (points[j][1] - points[i][1]) * (points[k][0] - points[i][0])) {
                            ++currentPoints;
                        }
                    }
                }
                maxPoints = Math.max(maxPoints, currentPoints);
            }
        }
        return maxPoints;
        */
    }
}