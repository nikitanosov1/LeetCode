package problem_2244;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : tasks) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int result = 0;
        for (Integer value : map.values()) {
            if (value == 1) return -1;
            if (value == 2 || value == 3) {
                result++;
                continue;
            }
            result += value / 3;
            if (value % 3 != 0) {
                result++;
            }
        }
        return result;
    }
}
