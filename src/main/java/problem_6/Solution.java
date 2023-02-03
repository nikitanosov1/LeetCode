package problem_6;

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        int n = s.length();
        StringBuilder sb = new StringBuilder();

        // collect first row
        int i = 0;
        while (i < n) {
            sb.append(s.charAt(i));
            i += 2 * (numRows - 1);
        }

        // collect [1, ... , numRows - 2] rows
        i = 0;
        for (int row = 1; row < numRows - 1; ++row) {
            int firstJump = 2 * (numRows - row - 1);
            int secondJump = 2 * row;

            i = row;
            boolean nowIsFirstJump = true;
            while (i < n) {
                sb.append(s.charAt(i));
                if (nowIsFirstJump) {
                    i += firstJump;
                } else {
                    i += secondJump;
                }
                nowIsFirstJump = !nowIsFirstJump;
            }
        }

        // collect last row (numRows - 1)
        i = numRows - 1;
        while (i < n) {
            sb.append(s.charAt(i));
            i += 2 * (numRows - 1);
        }

        return sb.toString();
    }
}