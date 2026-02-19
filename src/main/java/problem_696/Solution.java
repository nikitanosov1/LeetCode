package problem_696;
/*
 * @author Nikita Nosov
 * Date: 2/19/2026
 */

class Solution {
    public int countBinarySubstrings(String s) {
        int ansZeroOne = getCountBinarySubstrings01(s);
        String reverseS = new StringBuilder(s).reverse().toString();
        int ansOneZero = getCountBinarySubstrings01(reverseS);
        return ansZeroOne + ansOneZero;
    }

    private int getCountBinarySubstrings01(String s) {
        int answer = 0;
        int count = 0;
        boolean isPrevCharIsOne = true;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                if (isPrevCharIsOne) {
                    isPrevCharIsOne = false;
                    count = 1;
                } else {
                    ++count;
                }
            } else {
                if (count > 0) {
                    --count;
                    ++answer;
                }
                isPrevCharIsOne = true;
            }
        }
        return answer;
    }
}
