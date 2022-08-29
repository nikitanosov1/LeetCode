package problem_200;

class Solution {
    private char[][] globalGrid;

    public int numIslands(char[][] grid) {
        globalGrid = grid;
        int countOfIslands = 0;
        for (int i = 0; i < globalGrid.length; i++) {
            for (int j = 0; j < globalGrid[0].length; j++) {
                if (globalGrid[i][j] == '1'){
                    ++countOfIslands;
                    fillIsland(i, j);
                }
            }
        }
        return countOfIslands;
    }

    private void fillIsland(int i, int j){
        if (globalGrid[i][j] == '1'){
            globalGrid[i][j] = '2';
            if (i > 0) fillIsland(i - 1, j);
            if (i < globalGrid.length - 1) fillIsland(i + 1, j);
            if (j > 0) fillIsland(i, j - 1);
            if (j < globalGrid[0].length - 1) fillIsland(i, j + 1);
        }
    }
}