package problem_835;

class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int maxOverlap = 0;
        int n = img1.length;

        for (int i = 0; i < 2 * n - 1; ++i) {
            for (int j = 0; j < 2 * n - 1; ++j) {
                int curOverlap = 0;
                // absolute coords kOm
                for (int k = Math.max(n - 1, i); k <= Math.min(2 * n - 2, i + n - 1); ++k) {
                    for (int m = Math.max(n - 1, j); m <= Math.min(2 * n - 2, j + n - 1); ++m) {
                        int x2 = k - (n - 1);
                        int y2 = m - (n - 1);

                        int x1 = k - i;
                        int y1 = m - j;

                        if (img1[y1][x1] == 1 && img2[y2][x2] == 1) {
                            curOverlap++;
                        }
                    }
                }
                maxOverlap = Math.max(maxOverlap, curOverlap);
            }
        }
        return maxOverlap;
    }
}