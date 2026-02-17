package problem_401;
/*
 * @author Nikita Nosov
 * Date: 2/17/2026
 */

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    result.add(String.format("%d:%02d", h, m));
                }
            }
        }

        return result;
    }

    /** Моё первое решение
    public List<String> readBinaryWatch(int turnedOn) {
        int[] isScreenOnIn = new int[10];
        Set<String> result = new HashSet<>();
        process(result, turnedOn, isScreenOnIn);
        return new ArrayList<>(result);
    }

    private void process(Set<String> result, int turnedOn, int[] isScreenOnIn) {
        if (turnedOn == 0) {
            result.add(isScreenOnToString(isScreenOnIn));
            return;
        }
        int[] copyIsScreenOnIn = isScreenOnIn.clone();
        for (int i = 0; i < 10; i++) {
            if (copyIsScreenOnIn[i] == 0) {
                copyIsScreenOnIn[i] = 1;
                if (getHours(copyIsScreenOnIn) <= 11 && getMinutes(copyIsScreenOnIn) <= 59) {
                    process(result, turnedOn - 1, copyIsScreenOnIn);
                }
                copyIsScreenOnIn[i] = 0;
            }
        }
    }

    private String isScreenOnToString(int[] isScreenOnIn) {
        int hours = getHours(isScreenOnIn);
        int minutes = getMinutes(isScreenOnIn);
        return String.format("%01d:%02d", hours, minutes);
    }

    private int getHours(int[] isScreenOnIn) {
        return isScreenOnIn[0] * 8 + isScreenOnIn[1] * 4 + isScreenOnIn[2] * 2 + isScreenOnIn[3];
    }

    private int getMinutes(int[] isScreenOnIn) {
        return isScreenOnIn[4] * 32 + isScreenOnIn[5] * 16 + isScreenOnIn[6] * 8 + isScreenOnIn[7] * 4
                + isScreenOnIn[8] * 2 + isScreenOnIn[9];
    }
    */
}
