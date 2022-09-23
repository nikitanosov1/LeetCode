package problem_1680;

class Solution {
    public int concatenatedBinary(int n) {
        long modulo =(long) (1e9 + 7);
        long result = 0;
        int shift = 0;

        for (int i = 1; i < n + 1; ++i) {
            shift = ((i & (i - 1)) == 0) ? shift + 1 : shift;
            result = ((result << shift) + i) % modulo;
        }
        return (int) result;
    }
}