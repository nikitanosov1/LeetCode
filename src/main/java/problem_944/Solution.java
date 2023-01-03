package problem_944;

class Solution {
    public int minDeletionSize(String[] strs) {
        int result = 0;
        for (int column = 0; column < strs[0].length(); ++column) {
            boolean sorted = true;
            for (int i = 1; i < strs.length; ++i) {
                if (strs[i - 1].charAt(column) > strs[i].charAt(column)) {
                    sorted = false;
                    break;
                }
            }
            if (!sorted) result++;
        }
        return result;
    }
}