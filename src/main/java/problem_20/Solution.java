package problem_20;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
                stack.add(currentChar);
            } else {
                try {
                    char pairedBracket = stack.pollLast();
                    if (map.get(currentChar) != pairedBracket) return false;
                } catch (NullPointerException e) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}