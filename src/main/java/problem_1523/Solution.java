package problem_1523;

class Solution {
    public int countOdds(int low, int high) {
        int count = high - low + 1;
        return count / 2 + (((low % 2 == 1) && (count % 2 == 1)) ? 1 : 0);
    }
}