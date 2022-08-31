package problem_417;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private int[][] matrix;
    private int m;
    private int n;
    // -1 denotes that cell has path to Pacific Ocean
    // -2 denotes that cell has path to Atlantic Ocean
    // -3 denotes that cell has both paths to the Atlantic and the Pacific Oceans
    private int[][] originalHeights;


    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        matrix = heights;
        m = matrix.length;
        n = matrix[0].length;
        originalHeights = heights.clone();
        for (int i = 0; i < m; i++) {
            originalHeights[i] = heights[i].clone();
        }

        List<List<Integer>> cells = new ArrayList<>();

        for (int i = 0; i < m; i++) fillPacificCell(i, 0);
        for (int i = 0; i < n; i++) fillPacificCell(0, i);
        for (int i = 0; i < m; i++) fillAtlanticCell(i, n - 1);
        for (int i = 0; i < n; i++) fillAtlanticCell(m - 1, i);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -3) cells.add(List.of(i, j));
            }
        }
        return cells;
    }

    private void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void fillPacificCell(int i, int j){
        if (matrix[i][j] == -1) return;
        matrix[i][j] = -1;
        if (i > 0 && originalHeights[i - 1][j] >= originalHeights[i][j]) fillPacificCell(i - 1, j);
        if (i < m - 1 && originalHeights[i + 1][j] >= originalHeights[i][j]) fillPacificCell(i + 1, j);
        if (j > 0 && originalHeights[i][j - 1] >= originalHeights[i][j]) fillPacificCell(i, j - 1);
        if (j < n - 1 && originalHeights[i][j + 1] >= originalHeights[i][j]) fillPacificCell(i, j + 1);
    }

    private void fillAtlanticCell(int i, int j){
        if (matrix[i][j] == -2 || matrix[i][j] == -3) return;
        if (matrix[i][j] == -1) matrix[i][j] = -3;
        else matrix[i][j] = -2;
        if (i > 0 && originalHeights[i - 1][j] >= originalHeights[i][j]) fillAtlanticCell(i - 1, j);
        if (i < m - 1 && originalHeights[i + 1][j] >= originalHeights[i][j]) fillAtlanticCell(i + 1, j);
        if (j > 0 && originalHeights[i][j - 1] >= originalHeights[i][j]) fillAtlanticCell(i, j - 1);
        if (j < n - 1 && originalHeights[i][j + 1] >= originalHeights[i][j]) fillAtlanticCell(i, j + 1);
    }
}
