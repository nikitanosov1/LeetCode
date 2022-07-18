package problem_14;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        int minLength = 1_000_000;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }

        String result = "";
        boolean isFits = true;
        for (int i = 0; i < minLength; i++) {
            char currentChar = strs[0].charAt(i);

            isFits = true;
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != currentChar){
                    isFits = false;
                    break;
                }
            }
            if (!isFits){
                if (i == 0) break;
                result = strs[0].substring(0, i);
                break;
            }
        }
        if (isFits) result = strs[0].substring(0, minLength);
        return result;
    }
}