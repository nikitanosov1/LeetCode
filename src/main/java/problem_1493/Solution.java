package problem_1493;

class Solution {
    public int longestSubarray(int[] nums) {
        int prev = 0;
        int current = 0;
        int answer = 0;

        int countZeros = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                ++countZeros;
            }
        }
        if (countZeros == 0) return nums.length - 1;


        countZeros = 0;
        boolean isPrevZero = true;
        boolean canSum = true;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 1) {
                if (isPrevZero) {
                    isPrevZero = false;
                    prev = current;
                    current = 1;
                    canSum = (countZeros == 1);
                    countZeros = 0;
                } else {
                    current += 1;
                }
                if (canSum) answer = Math.max(answer, current + prev);
                else answer = Math.max(answer, current);
            } else {
                countZeros++;
                isPrevZero = true;
            }
        }
        return answer;
    }
}