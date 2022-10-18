package problem_228;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new LinkedList<>();
        if (nums.length == 0) return result;

        int startDigit = nums[0];
        int length = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == nums[i - 1] + 1) {
                ++length;
            } else {
                if (length == 1) {
                    result.add(Integer.toString(startDigit));
                } else {
                    sb.append(startDigit).append("->").append(nums[i - 1]);
                    result.add(sb.toString());
                    sb.setLength(0);
                    length = 1;
                }
                startDigit = nums[i];
            }
        }
        if (length == 1) {
            result.add(Integer.toString(startDigit));
        } else {
            sb.append(startDigit).append("->").append(nums[nums.length - 1]);
            result.add(sb.toString());
        }
        return result;
    }
}