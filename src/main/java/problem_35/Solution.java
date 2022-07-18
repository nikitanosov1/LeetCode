package problem_35;

class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right - 1){
            int mid = (left + right) / 2;
            if (nums[mid] > target){
                right = mid;
            }else{
                left = mid;
            }
        }
        if (left == 0 && nums[left] > target) return 0;
        return (nums[left] == target) ? left : left + 1;
    }
}