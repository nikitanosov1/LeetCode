package problem_926;

class Solution {
    public int minFlipsMonoIncr(String s) {
        int rightOnes = 0;
        int rightZeros = 0;
        int leftOnes = 0;
        int leftZeros = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '1') {
                rightOnes++;
            } else {
                rightZeros++;
            }
        }

        int minFlips = 1_000_000;
        // if all coins flip to '1'
        minFlips = Math.min(minFlips, rightZeros);
        // if all coins after i-coin flip to '1'
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '1') {
                rightOnes--;
                leftOnes++;
            } else {
                rightZeros--;
                leftZeros++;
            }
            minFlips = Math.min(minFlips, leftOnes + rightZeros);
        }
        return minFlips;
    }
}