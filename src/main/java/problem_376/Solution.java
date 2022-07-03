package problem_376;

class Solution {
    public int wiggleMaxLength(int[] nums) {
        int lastDiff;
        if (nums.length == 1) return 1;
        int index = 1;
        while (index < nums.length && nums[index] == nums[index - 1]){
            ++index;
        }
        if (index == nums.length) return 1;
        lastDiff = nums[index] - nums[index - 1];
        int count = 2;
        int currentDiff;
        for (int i = index + 1; i < nums.length; i++) {
            currentDiff = nums[i] - nums[i - 1];
            if (currentDiff == 0) continue;
            if ((lastDiff > 0 && currentDiff < 0) || (lastDiff < 0 && currentDiff > 0)){
                lastDiff = currentDiff;
                ++count;
            }
        }
        return count;
    }
}