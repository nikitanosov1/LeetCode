package problem_560;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {
        /*
        This is the best solution: O(n) time and O(n) memory
         */
        // this map contains history of prefixSum and count of this sum
        Map<Integer, Integer> map = new HashMap<>();

        int count = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (sum == k) ++count;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;

        /*
        O(n^2) time and O(1) memory

        // calc prefix sum
        int[] prefix = new int[nums.length + 1];
        for (int i = 1; i < nums.length + 1; ++i) {
            prefix[i] = nums[i - 1] + prefix[i - 1];
        }

        int count = 0;
        for (int i = 1; i < nums.length + 1; ++i) { // i - current size
            for (int j = 0; j < nums.length - i + 1; ++j) { // j - index of start
                if ((prefix[i + j] - prefix[j]) == k) {
                    ++count;
                }
            }
        }
        return count;
         */
    }
}