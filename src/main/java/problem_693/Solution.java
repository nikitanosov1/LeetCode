package problem_693;
/*
 * @author Nikita Nosov
 * Date: 2/18/2026
 */

class Solution {
    public boolean hasAlternatingBits(int n) {
        int prevBit = -1;
        while (n > 0) {
            int currentLastBit = n & 1;
            if (prevBit == -1) {
                prevBit = currentLastBit;
            } else {
                if (prevBit == currentLastBit) return false;
                prevBit = currentLastBit;
            }
            n >>= 1;
        }
        return true;
    }
}
