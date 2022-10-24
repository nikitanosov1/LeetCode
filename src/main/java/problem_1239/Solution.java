package problem_1239;

import java.util.List;

class Solution {
    private int length;
    private int maxLength;
    private List<String> array;

    public int maxLength(List<String> arr) {
        length = arr.size();
        array = arr;
        recursion(0,false, new int[26]);
        recursion(0,true, new int[26]);
        return maxLength;
    }

    void recursion(int index, boolean isTaken, int[] currentFrequency) {
        if (index == length) return;
        if (!isTaken) {
            recursion(index + 1, false, currentFrequency.clone());
            recursion(index + 1, true, currentFrequency.clone());
        } else {
            for (int i = 0; i < array.get(index).length(); ++i) {
                if (currentFrequency[array.get(index).charAt(i) - 'a'] == 0) {
                    currentFrequency[array.get(index).charAt(i) - 'a'] = 1;
                } else {
                    return; // char isn't uniques
                }
            }
            int curLength = 0;
            for (int i = 0; i < 26; ++i){
                curLength += currentFrequency[i];
            }
            maxLength = Math.max(maxLength, curLength);
            recursion(index + 1,  false, currentFrequency.clone());
            recursion(index + 1,  true, currentFrequency.clone());
        }
    }
}