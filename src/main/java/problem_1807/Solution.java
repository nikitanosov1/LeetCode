package problem_1807;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        StringBuilder answer = new StringBuilder();
        boolean inBracket = false;

        Map<String, String> map = new HashMap<>();
        for (List<String> list : knowledge){
            map.put(list.get(0), list.get(1));
        }

        StringBuilder word = new StringBuilder();

        for (int i = 0; i < s.length(); ++i){
            char c = s.charAt(i);
            if (inBracket) {
                if (c == ')'){
                    String key = word.toString();
                    answer.append(map.getOrDefault(key, "?"));
                    inBracket = false;
                } else {
                    word.append(c);
                }
            } else {
                if (c == '('){
                    inBracket = true;
                    word.setLength(0);
                } else {
                    answer.append(c);
                }
            }
        }
        return answer.toString();
    }
}