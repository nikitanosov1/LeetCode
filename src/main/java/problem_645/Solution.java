package problem_645;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] findErrorNums(int[] nums) {
        int duplicatedNumber = -1;
        int sumOfNums = nums[0];
        Set<Integer> numsSet = new HashSet<>();
        numsSet.add(nums[0]);
        for (int i = 1; i < nums.length; ++i) {
            sumOfNums += nums[i];
            if (numsSet.contains(nums[i])) {
                duplicatedNumber = nums[i];
            } else {
                numsSet.add(nums[i]);
            }
        }

        int requiredSumOfNums = (1 + nums.length) * nums.length / 2;
        int missedNumber = duplicatedNumber - (sumOfNums - requiredSumOfNums);
        return new int[]{duplicatedNumber, missedNumber};
    }
}