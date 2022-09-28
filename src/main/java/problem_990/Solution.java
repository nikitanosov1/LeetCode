package problem_990;

import java.util.*;

class Solution {
    private Map<Character, Set<Character>> map = new HashMap<>();

    public boolean equationsPossible(String[] equations) {
        for (String equation : equations) {
            char firstChar = equation.charAt(0);
            char secondChar = equation.charAt(3);
            if (equation.charAt(1) == '=') {
                if (firstChar == secondChar) {
                    continue;
                }
                if (map.containsKey(firstChar)) {
                    Set<Character> set = map.get(firstChar);
                    for (Character c : set.stream().toList()) {
                        map.get(c).add(secondChar);
                        if (map.containsKey(secondChar)) {
                            map.get(secondChar).add(c);
                        } else {
                            map.put(secondChar, new HashSet<Character>(List.of(c)));
                        }
                    }
                } else {
                    map.put(firstChar, new HashSet<Character>(List.of(firstChar, secondChar)));
                }
                // "a==b", "c==e", "b==c", "a!=e"
                if (map.containsKey(secondChar)) {
                    Set<Character> set = map.get(secondChar);
                    for (Character c : set.stream().toList()) {
                        map.get(c).add(firstChar);
                        if (map.containsKey(firstChar)) {
                            map.get(firstChar).add(c);
                        } else {
                            map.put(secondChar, new HashSet<Character>(List.of(c)));
                        }
                    }
                } else {
                    map.put(secondChar, new HashSet<Character>(List.of(firstChar, secondChar)));
                }
            }
        }

        for (String equation : equations) {
            char firstChar = equation.charAt(0);
            char secondChar = equation.charAt(3);
            if (equation.charAt(1) == '!') {
                if (firstChar == secondChar) {
                    return false;
                }

                for (Set<Character> set : map.values()) {
                    if (set.contains(firstChar) && set.contains(secondChar)) return false;
                }
            }
        }
        return true;
    }
}