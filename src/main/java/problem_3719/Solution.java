package problem_3719;
/*
 * @author Nikita Nosov
 * Date: 2/10/2026
 */

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int answer = 0;
        Set<Integer> oddNumbers = new HashSet<>();
        Set<Integer> evenNumbers = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (nums[j] % 2 == 0) {
                    evenNumbers.add(nums[j]);
                } else {
                    oddNumbers.add(nums[j]);
                }

                if (evenNumbers.size() == oddNumbers.size()) {
                    answer = Math.max(answer, j - i + 1);
                }
            }
            evenNumbers = new HashSet<>();
            oddNumbers = new HashSet<>();
        }
        return answer;
    }
}
