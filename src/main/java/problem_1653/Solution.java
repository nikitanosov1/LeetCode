package problem_1653;

class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int[] bCharsLeft = new int[n];
        int[] aCharsRight = new int[n];
        bCharsLeft[0] = 0;
        aCharsRight[n - 1] = 0;
        for (int i = 1; i < n; ++i) {
            bCharsLeft[i] = bCharsLeft[i - 1] + (s.charAt(i - 1) == 'b' ? 1 : 0);
        }

        for (int i = n - 2; i > -1; --i) {
            aCharsRight[i] = aCharsRight[i + 1] + (s.charAt(i + 1) == 'a' ? 1 : 0);
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            result = Math.min(bCharsLeft[i] + aCharsRight[i], result);
        }

        return result;
    }
}
