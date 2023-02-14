package problem_67;

class Solution {
    public String addBinary(String a, String b) {
        int n = a.length();
        int m = b.length();

        int toNext = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.max(n, m); ++i) {
            char aChar = (n - 1 - i < 0) ? '0' : a.charAt(n - 1 - i);
            char bChar = (m - 1 - i < 0) ? '0' : b.charAt(m - 1 - i);
            int result = toNext;
            if (aChar == '1') result++;
            if (bChar == '1') result++;
            sb.append(result % 2);
            toNext = result / 2;
        }

        if (toNext == 1) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }
}