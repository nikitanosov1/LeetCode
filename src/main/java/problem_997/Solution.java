package problem_997;

class Solution {
    public int findJudge(int n, int[][] trust) {
        int xorResult = 0;
        for (int i = 1; i < n + 1; ++i) {
            xorResult ^= i;
        }

        for (int i = 1; i < n + 1; ++i) {
            boolean isJudge = true;
            int currentXor = 0;
            for (int j = 0; j < trust.length; ++j) {
                // check "The town judge trusts nobody"
                if (trust[j][0] == i) {
                    isJudge = false;
                    break;
                }
                // check "Everybody (except for the town judge) trusts the town judge."
                if (trust[j][1] == i) {
                    currentXor ^= trust[j][0];
                }
            }

            if (isJudge && ((currentXor ^ xorResult) == i)) {
                return i;
            }
        }
        return -1;
    }
}