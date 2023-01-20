package problem_491;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> resultSet = new HashSet<>();

        int n = nums.length;
        for (int bitmask = 0; bitmask < (1 << n); ++bitmask) {
            List<Integer> subSeq = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                int isTaken = (bitmask >> (n - 1 - i)) & 1;
                if (isTaken == 1) {
                    subSeq.add(nums[i]);
                }
            }

            if (subSeq.size() < 2) continue;

            // check subSeq
            boolean isGood = true;
            for (int i = 1; i < subSeq.size(); ++i) {
                if (subSeq.get(i) < subSeq.get(i - 1)) {
                    isGood = false;
                    break;
                }
            }
            if (isGood) {
                resultSet.add(subSeq);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> list : resultSet) {
            result.add(list);
        }
        return result;
    }
}