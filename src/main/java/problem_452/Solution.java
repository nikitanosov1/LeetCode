package problem_452;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
                if (o1[0] < o2[0]) return -1;
                if (o1[0] > o2[0]) return 1;
                return 0;
            }
        });

        //int left = points[0][0]; // max x_start
        int right = points[0][1]; // min x_end
        int result = 1;
        for (int i = 1; i < points.length; ++i) {
            if (points[i][0] > right) {
                result++;
                //left = points[i][0];
                right = points[i][1];
            } else if (points[i][1] <= right) {
                //left = points[i][0];
                right = points[i][1];
            }
            // else {
                //left = points[i][0];
            // }
        }
        return result;
    }
}