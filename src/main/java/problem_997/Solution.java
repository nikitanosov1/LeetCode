package problem_997;

class Solution {
    public int findJudge(int n, int[][] trust) {
        // bad memory, good time
        int[][] counts = new int[n][2];

        for (int i = 0; i < trust.length; ++i) {
            counts[trust[i][1] - 1][1]++;
            counts[trust[i][0] - 1][0]++;
        }

        for (int i = 0; i < n; ++i) {
            if (counts[i][0] == 0 && counts[i][1] == n - 1) return i + 1;
        }
        return -1;

        /* good memory
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
        */
    }
}