package problem_58;

class Solution {
    public int lengthOfLastWord(String s) {
        int length = s.length();
        boolean isEndSpacesOver = false;
        int lastWordStartIndex = 0;
        int lastWordEndIndex = length - 1;

        for (int i = length - 1; i > -1; --i) {
            char c = s.charAt(i);
            if (isEndSpacesOver) {
                if (c == ' ') {
                    lastWordStartIndex = i + 1;
                    break;
                }
            } else {
                if (c != ' ') {
                    isEndSpacesOver = true;
                    lastWordEndIndex = i;
                }
            }
        }

        return s.substring(lastWordStartIndex, lastWordEndIndex + 1).length();
    }
}
