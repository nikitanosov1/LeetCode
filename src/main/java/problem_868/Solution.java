package problem_868;
/*
 * @author Nikita Nosov
 * Date: 2/22/2026
 */

class Solution {
    public int binaryGap(int n) {
        String s = Integer.toBinaryString(n);
        int ans = -1;
        int indexOfLastOne = -1;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '1') {
                if (indexOfLastOne == -1) {
                    indexOfLastOne = i;
                } else {
                    ans = Math.max(ans, i - indexOfLastOne);
                    indexOfLastOne = i;
                }
            }
        }
        return (ans == -1) ? 0 : ans;
    }
}
