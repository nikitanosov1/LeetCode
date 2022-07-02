package problem_1465;

import java.util.Arrays;

class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int maxWeight = verticalCuts[0];
        for (int i = 1; i < verticalCuts.length; i++) {
            if (verticalCuts[i] - verticalCuts[i - 1] > maxWeight){
                maxWeight = verticalCuts[i] - verticalCuts[i - 1];
            }
        }
        if (w - verticalCuts[verticalCuts.length - 1] > maxWeight){
            maxWeight = w - verticalCuts[verticalCuts.length - 1];
        }

        int maxHeight = horizontalCuts[0];
        for (int i = 1; i < horizontalCuts.length; i++) {
            if (horizontalCuts[i] - horizontalCuts[i - 1] > maxHeight){
                maxHeight = horizontalCuts[i] - horizontalCuts[i - 1];
            }
        }
        if (h - horizontalCuts[horizontalCuts.length - 1] > maxHeight){
            maxHeight = h - horizontalCuts[horizontalCuts.length - 1];
        }

        return (int) (((long)maxHeight * maxWeight) % (1_000_000_007));
    }
}
