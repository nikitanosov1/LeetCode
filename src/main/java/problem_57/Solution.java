package problem_57;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        List<Integer> isDelete = new ArrayList<>();

        for (int i = 0; i < intervals.length; ++i) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (start >= newStart && end <= newEnd) {
                isDelete.add(i);
            } else if (start < newStart && end >= newStart && end <= newEnd) {
                newStart = start;
                isDelete.add(i);
            } else if (end > newEnd && start >= newStart && start <= newEnd) {
                newEnd = end;
                isDelete.add(i);
            } else if (start < newStart && end > newEnd) {
                return intervals;
            }
        }

        int[][] result = new int[intervals.length - isDelete.size() + 1][2];
        int j = 0;
        int index = 0;
        for (int i = 0; i < intervals.length; ++i) {
            if (index < isDelete.size() && isDelete.get(index) == i) {
                index++;
                continue;
            }
            result[j] = new int[] {intervals[i][0], intervals[i][1]};
            j++;
        }
        result[result.length - 1] = new int[] {newStart, newEnd};
        for (int i = result.length - 1; i > 0; --i) {
            if (result[i][0] < result[i - 1][0]) {
                result[i][0] ^= result[i - 1][0];
                result[i - 1][0] ^= result[i][0];
                result[i][0] ^= result[i - 1][0];

                result[i][1] ^= result[i - 1][1];
                result[i - 1][1] ^= result[i][1];
                result[i][1] ^= result[i - 1][1];
            }
        }
        return result;
    }
}