package problem_93;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i < 4; ++i) {
            for (int j = 1; j < 4; ++j) {
                for (int k = 1; k < 4; ++k) {
                    for (int l = 1; l < 4; ++l) {
                        if (i + j + k + l != s.length()) continue;

                        String first = s.substring(0, i);
                        if (i > 1 && first.charAt(0) == '0') continue;
                        if (Integer.parseInt(first) > 255) continue;

                        String second = s.substring(i, i + j);
                        if (j > 1 && second.charAt(0) == '0') continue;
                        if (Integer.parseInt(second) > 255) continue;

                        String third = s.substring(i + j, i + j + k);
                        if (k > 1 && third.charAt(0) == '0') continue;
                        if (Integer.parseInt(third) > 255) continue;

                        String fourth = s.substring(i + j + k, i + j + k + l);
                        if (l > 1 && fourth.charAt(0) == '0') continue;
                        if (Integer.parseInt(fourth) > 255) continue;

                        StringBuilder sb = new StringBuilder();
                        sb.append(first).append(".")
                                .append(second).append(".")
                                .append(third).append(".")
                                .append(fourth);
                        result.add(sb.toString());
                    }
                }
            }
        }
        return result;
    }
}