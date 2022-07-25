package problem_34;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = leftBinSearch(nums, target);
        int right = rightBinSearch(nums, target);
        if (left == -1 || right == -1) return new int[]{-1, -1};
        return new int[]{left, right};
    }

    /**
     * find right index of target. If target hasn't found return -1.
     *
     * @param nums - sorted array,
     * @param target - number which we want to find.
     */
    public int rightBinSearch(int[] nums, int target){
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length;
        while (left + 1 != right){
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target){
                left = mid;
            }else{
                right = mid;
            }
        }
        if (nums[left] != target) return -1;
        return left;
    }

    /**
     * find left index of target. If target hasn't found return -1.
     *
     * @param nums - sorted array,
     * @param target - number which we want to find.
     */
    public int leftBinSearch(int[] nums, int target){
        if (nums.length == 0) return -1;
        int left = -1;
        int right = nums.length - 1;
        while (left + 1 != right){
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target){
                right = mid;
            }else{
                left = mid;
            }
        }
        if (nums[right] != target) return -1;
        return right;
    }
}