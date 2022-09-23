package problem_1754;

class Solution {
    public String largestMerge(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;

        while (i < word1.length() && j < word2.length()) {
            if (word1.charAt(i) < word2.charAt(j)) {
                sb.append(word2.charAt(j));
                ++j;
            } else if (word1.charAt(i) > word2.charAt(j)) {
                sb.append(word1.charAt(i));
                ++i;
            } else {
                int ii = i;
                int jj = j;
                while (ii < word1.length() && jj < word2.length() && word1.charAt(ii) == word2.charAt(jj)) {
                    ++ii;
                    ++jj;
                }
                char charFromWord1 = (ii == word1.length()) ? 'a' - 1: word1.charAt(ii);
                char charFromWord2 = (jj == word2.length()) ? 'a' - 1: word2.charAt(jj);

                if (charFromWord1 < charFromWord2) {
                    sb.append(word2.charAt(j));
                    ++j;
                } else {
                    sb.append(word1.charAt(i));
                    ++i;
                }
            }
        }
        while (i < word1.length()) {
            sb.append(word1.charAt(i));
            ++i;
        }
        while (j < word2.length()) {
            sb.append(word2.charAt(j));
            ++j;
        }
        return sb.toString();
    }
}