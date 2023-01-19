package problem_974;

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] counts = new int[k];
        counts[0] = 1;
        int sum = 0;
        int result = 0;
        for (int num : nums) {
            sum += num;
            int ost = (sum % k < 0) ? k + (sum % k) : sum % k;
            result += counts[ost];
            counts[ost]++;
        }
        return result;
    }
}