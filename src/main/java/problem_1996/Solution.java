package problem_1996;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o2[1] - o1[1];
                return o2[0] - o1[0];
            }
        });
        int currentAttack = properties[0][0];
        int maxDefence = Integer.MIN_VALUE;
        int localMaxDefence = properties[0][1];
        int answer = 0;
        for (int[] property : properties) {
            //System.out.println(property[0] + " " + property[1]);
            if (property[0] < currentAttack){
                maxDefence = Math.max(maxDefence, localMaxDefence);
                if (maxDefence > property[1]) answer++;
                localMaxDefence = property[1];
                currentAttack = property[0];
            } else {
                if (maxDefence > property[1]) answer++;
                localMaxDefence = Math.max(localMaxDefence, property[1]);
            }
        }
        return answer;
    }
}