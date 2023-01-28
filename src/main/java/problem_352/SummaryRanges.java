package problem_352;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class SummaryRanges {
    private List<List<Integer>> intervals;

    public SummaryRanges() {
        intervals = new LinkedList<>();
    }

    public void addNum(int value) {
        int index = -1;
        for (int i = 0; i < intervals.size(); ++i) {
            // * - it's the point
            // [i] - it's the i-interval
            int start = intervals.get(i).get(0);
            int end = intervals.get(i).get(1);

            // if point already exists
            if (start <= value && value <= end) {
                return;
            }

            // need to add on the left (*[i])
            if (value + 1 == start) {
                // if [i - 1]*[i]
                if (i != 0 && intervals.get(i - 1).get(1) + 1 == value) {
                    intervals.get(i - 1).set(1, end);
                    intervals.remove(i);
                    return;
                }

                // if [i - 1]    *[i]
                intervals.get(i).set(0, value);
                return;
            }

            // need to add on the right ([i]*)
            if (end + 1 == value) {
                // if [i]*[i+1]
                if (i != intervals.size() - 1 && value + 1 == intervals.get(i + 1).get(0)) {
                    intervals.get(i).set(1, intervals.get(i + 1).get(1));
                    intervals.remove(i + 1);
                    return;
                }

                // if [i]* [i+1]
                intervals.get(i).set(1, value);
                return;
            }

            // for future insert
            if (start < value) {
                index = i;
            }
        }
        // if [index]   *   [index + 1]
        intervals.add(index + 1, new ArrayList<>(List.of(value, value)));
        return;
    }

    public int[][] getIntervals() {
        int[][] arrIntervals = new int[intervals.size()][2];
        for (int i = 0; i < intervals.size(); ++i) {
            arrIntervals[i] = new int[]{intervals.get(i).get(0), intervals.get(i).get(1)};
        }
        return arrIntervals;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */