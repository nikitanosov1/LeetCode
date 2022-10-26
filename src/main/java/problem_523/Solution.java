package problem_523;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            int temp = sum % k;
            if (map.containsKey(temp)) {
                if ((i - map.get(temp)) >= 2) {
                    return true;
                }
            } else {
                map.put(temp, i);
            }
        }
        return false;
    }
}
