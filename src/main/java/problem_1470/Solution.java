package problem_1470;

class Solution {
    public int[] shuffle(int[] nums, int n) {
        /*
        Time: O(n)
        Space: O(1)
         */
        for (int i = n; i < 2 * n; ++i) {
            nums[i - n] |= nums[i] << 10;
        }

        int helpInt = (int) Math.pow(2, 10) - 1;
        for (int i = n - 1; i >= 0; --i) {
            nums[2 * i + 1] = nums[i] >> 10;
            nums[2 * i] = nums[i] & helpInt;
        }
        return nums;

        /*
        Time: O(n)
        Space: O(1), but we are using additional space for answer

        int[] shuffleArr = new int[2 * n];
        for (int i = 0; i < n; ++i) {
            shuffleArr[2 * i] = nums[i];
            shuffleArr[2 * i + 1] = nums[n + i];
        }
        return shuffleArr;
        */
    }
}