package problem_540;

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int r = nums.length - 1;
        int l = -1;

        int mid;
        while (l + 1 < r) {
            mid = (l + r) / 2;
            if (f(mid, nums)) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return nums[r];
    }

    private boolean f(int index, int[] nums) {
        if (index % 2 == 0) {
            if (index == nums.length - 1) {
                return true;
            }
            return nums[index] != nums[index + 1];
        } else {
            return nums[index - 1] != nums[index];
        }
    }
}