package problem_1061;

class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] dsu = new int[26];
        int idOfNewGroup = 1;
        for (int i = 0; i < s1.length(); ++i) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (dsu[c1 - 'a'] == 0 && dsu[c2 - 'a'] == 0) {
                dsu[c1 - 'a'] = idOfNewGroup;
                dsu[c2 - 'a'] = idOfNewGroup;
                idOfNewGroup++;
            } else if (dsu[c1 - 'a'] == 0 && dsu[c2 - 'a'] != 0) {
                dsu[c1 - 'a'] = dsu[c2 - 'a'];
            } else if (dsu[c1 - 'a'] != 0 && dsu[c2 - 'a'] == 0) {
                dsu[c2 - 'a'] = dsu[c1 - 'a'];
            } else {
                int c1GroupId = dsu[c1 - 'a'];
                int c2GroupId = dsu[c2 - 'a'];
                for (int j = 0; j < dsu.length; ++j) {
                    if (dsu[j] == c1GroupId) {
                        dsu[j] = c2GroupId;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < baseStr.length(); ++i) {
            char c = baseStr.charAt(i);
            if (dsu[c - 'a'] == 0) {
                sb.append(c);
                continue;
            }
            for (int j = 0; j < dsu.length; ++j) {
                if (dsu[j] == dsu[c - 'a']) {
                    sb.append((char)('a' + j));
                    break;
                }
            }
        }
        return sb.toString();
    }
}
