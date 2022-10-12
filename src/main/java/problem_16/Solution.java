package problem_16;

import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int minDiff = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0 ; i < nums.length - 2; ++i) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int curSum = nums[i] + nums[left] + nums[right];
                if (Math.abs(curSum - target) < minDiff) {
                    minDiff = Math.abs(curSum - target);
                    result = curSum;
                }

                if (curSum == target) return target;
                if (curSum < target) ++left;
                if (curSum > target) --right;
            }
        }
        return result;
    }
}