package problem_967;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<Integer> nums = new ArrayList<>();
    private int maxLength;
    private int globalK;

    public int[] numsSameConsecDiff(int n, int k) {
        // min n = 2
        globalK = k;
        maxLength = n;
        for (int i = 1; i < 10; i++) { // no leading zero
            recursionGenerate(i, 1);
        }
        return nums.stream().mapToInt(o -> o).toArray();
    }

    private void recursionGenerate(int currentNum, int n){
        if (n == maxLength){
            nums.add(currentNum);
            return;
        }
        int lastDigit = currentNum % 10;
        if (lastDigit + globalK < 10) recursionGenerate(currentNum * 10 + lastDigit + globalK, n + 1);
        if (lastDigit - globalK > -1 && globalK != 0) recursionGenerate(currentNum * 10 + lastDigit - globalK, n + 1);
    }
}
