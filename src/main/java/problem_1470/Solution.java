package problem_1470;

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] shuffleArr = new int[2 * n];
        for (int i = 0; i < n; ++i) {
            shuffleArr[2 * i] = nums[i];
            shuffleArr[2 * i + 1] = nums[n + i];
        }
        return shuffleArr;
    }
}