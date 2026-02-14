package problem_799;
/*
 * @author Nikita Nosov
 * Date: 2/14/2026
 */

class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] A = new double[101][101];
        A[0][0] = poured;
        for (int r = 0; r <= query_row; r++) {
            for (int c = 0; c <= r; c++) {
                double half = (A[r][c] - 1) / 2;
                if (half > 0) {
                    A[r + 1][c] += half;
                    A[r + 1][c + 1] += half;
                }
            }
        }

        return Math.min(A[query_row][query_glass], 1);
    }
}
