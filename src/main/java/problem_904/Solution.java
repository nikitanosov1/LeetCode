package problem_904;

class Solution {
    public int totalFruit(int[] fruits) {
        int firstType = fruits[0];
        int secondType = -1;
        int maxFruits = 1;
        int startIndex = 0;
        int futureStartIndex = -1;

        for (int i = 1; i < fruits.length; ++i) {
            if (fruits[i] != firstType) {
                secondType = fruits[i];
                futureStartIndex = i;
                maxFruits = i + 1;
                break;
            }
            maxFruits = i + 1;
        }
        // now we have [x x x x x x y ...]
        // where x - it's firstType and y - it's secondType
        // futureStartIndex equals index of y
        for (int i = futureStartIndex + 1; i < fruits.length; ++i) {
            // update startIndex
            if (fruits[i] == firstType) {
                futureStartIndex = i;

                // swap firstType with secondType
                firstType ^= secondType;
                secondType ^= firstType;
                firstType ^= secondType;
            } else if (fruits[i] != secondType) {
                startIndex = futureStartIndex;
                futureStartIndex = i;
                firstType = secondType;
                secondType = fruits[i];
            }

            // update answer
            maxFruits = Math.max(maxFruits, i - startIndex + 1);
        }
        return maxFruits;
    }
}