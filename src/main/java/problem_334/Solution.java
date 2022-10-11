package problem_334;

class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length == 1 || nums.length == 2) return false;

        // minX from index 0 to i
        int minX = nums[0];

        // always full pair (x, y) where x < y and index(x) < index(y)
        boolean haveXY = false;
        int x = -1;
        int y = -1;

        for (int i = 1; i < nums.length; ++i) {
            if (haveXY && nums[i] > y) return true;

            if (nums[i] <= minX) {
                minX = nums[i];
            }
            else {
                if (haveXY) {
                    // maybe pair (minX, nums[i]) is better than (x, y)
                    if (nums[i] < y) {
                        x = minX;
                        y = nums[i];
                    }
                } else {
                    // First pair (x, y) init
                    haveXY = true;
                    x = minX;
                    y = nums[i];
                }
            }
        }
        return false;
    }
}