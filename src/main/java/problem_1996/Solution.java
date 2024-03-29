package problem_1996;

import java.util.Arrays;

class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties,(a,b)-> (a[0]==b[0])?a[1]-b[1]:b[0]-a[0]);
        int max = -1,res = 0;
        for(int[] property: properties){
            System.out.println(property[0] + " " + property[1]);
            if(property[1] < max) res++;
            else max = property[1];
        }
        return res;
    }
}