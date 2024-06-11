package problem_1122;

import java.util.*;

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> countsMap = new HashMap<>();
        Set<Integer> setOfArr2 = new HashSet<>();
        PriorityQueue<Integer> numbersInArr1AndNotInArr2 = new PriorityQueue<>();

        for (int i = 0; i < arr2.length; ++i) {
            setOfArr2.add(arr2[i]);
        }
        for (int i = 0; i < arr1.length; ++i) {
            countsMap.put(arr1[i], countsMap.getOrDefault(arr1[i], 0) + 1);
            if (!setOfArr2.contains(arr1[i])) {
                numbersInArr1AndNotInArr2.add(arr1[i]);
            }
        }

        int[] result = new int[arr1.length];
        int index = 0;
        for (int i = 0; i < arr2.length; ++i) {
            while (countsMap.get(arr2[i]) != 0) {
                result[index] = arr2[i];
                countsMap.put(arr2[i], countsMap.get(arr2[i]) - 1);
                ++index;
            }
        }

        for (int i = index; i < result.length; ++i) {
            result[i] = numbersInArr1AndNotInArr2.poll();
        }

        return result;
    }
}