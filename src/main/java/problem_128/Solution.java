package problem_128;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Set<Integer> hashSet = new HashSet<>();
        for (int x : nums) {
            hashSet.add(x);
        }
        int maxLength = 1;
        for (Integer integer : hashSet) {
            int x = integer;
            if (!hashSet.contains(x - 1)) {
                int currentLength = 1;
                while (hashSet.contains(x + 1)) {
                    ++x;
                    ++currentLength;
                }
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        return maxLength;
    }
}