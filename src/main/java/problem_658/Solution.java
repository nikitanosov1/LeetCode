package problem_658;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int a = 0;
        int b = arr.length - 1;
        while (b - a >= k) {
            if (Math.abs(arr[a] - x) > Math.abs(arr[b] - x)) {
                a++;
            } else {
                b--;
            }
        }
        List<Integer> result = new ArrayList<>(k);
        for (int i = a; i <= b; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}