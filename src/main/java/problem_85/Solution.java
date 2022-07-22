package problem_85;

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int w = matrix[0].length;
        int h = matrix.length;
        int maxSquare = 0;
        int[] currentRow = new int[w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (matrix[i][j] == '0') currentRow[j] = 0;
                else currentRow[j] += 1;
            }
            maxSquare = Math.max(maxSquare, maximalSquareInRow(currentRow));
        }
        return maxSquare;
    }

    public int maximalSquareInRow(int[] row){
        Stack<Integer> stack = new Stack<>();
        int[] lefts = new int[row.length];
        int[] rights = new int[row.length];
        // calculate left borders for each bar
        for (int i = 0; i < lefts.length; ++i) {
            while(!stack.isEmpty() && row[stack.peek()] >= row[i]){
                stack.pop();
            }
            if (stack.isEmpty()){
                lefts[i] = 0;
            }
            else {
                lefts[i] = stack.peek() + 1;
            }
            stack.push(i);
        }
        // calculate right borders for each bar
        stack.clear();
        for (int i = rights.length - 1; i > -1; --i) {
            while(!stack.isEmpty() && row[stack.peek()] >= row[i]){
                stack.pop();
            }
            if (stack.isEmpty()){
                rights[i] = rights.length - 1;
            }
            else {
                rights[i] = stack.peek() - 1;
            }
            stack.push(i);
        }
        // calculate max square ([i] bar contains FULL) for each bar
        int maxSquare = Integer.MIN_VALUE;
        for (int i = 0; i < row.length; i++) {
            maxSquare = Math.max(maxSquare, (rights[i] - lefts[i] + 1) * row[i]);
        }
        return maxSquare;
    }
}