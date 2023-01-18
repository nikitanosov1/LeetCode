package problem_918;

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        // kadane for finding max subarray
        int maxKadane = 0;
        int maxSum = -1_000_000;

        // kadane for finding min subarray
        int minKadane = 0;
        int minSum = 1_000_000;

        int totalSum = 0;

        int maxNumb = -1_000_000;
        for (int i = 0; i < n; ++i) {
            // kadane for finding max subarray
            maxKadane = Math.max(maxKadane + nums[i], 0);
            maxSum = Math.max(maxSum, maxKadane);

            // kadane for finding min subarray
            minKadane = Math.min(minKadane + nums[i], 0);
            minSum = Math.min(minSum, minKadane);

            // totalSum
            totalSum += nums[i];

            // max number in nums
            maxNumb = Math.max(maxNumb, nums[i]);
        }

        return (maxSum == 0) ? maxNumb : Math.max(maxSum, totalSum - minSum);
    }
}
