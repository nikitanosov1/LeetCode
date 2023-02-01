package problem_1071;

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // do len(str1) < len(str2)
        if (str1.length() > str2.length()) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }

        // now len(str1) < len(str2)

        for (int i = str1.length(); i > 0; --i) {
            String subStr = str1.substring(0, i);

            // check subStr (good or not)
            if (isConsists(subStr, str1) && isConsists(subStr, str2)) return subStr;
        }
        return "";
    }

    /**
     * Checking that bigStr can be represented as str + str + ... + str
     * @param str - small string
     * @param bigStr - big string
     * @return true, if bigStr can be represented as str + str + ... + str, otherwise false
     */
    private boolean isConsists(String str, String bigStr) {
        if (bigStr.length() % str.length() != 0) return false;

        for (int i = 0; i < bigStr.length(); ++i) {
            if (bigStr.charAt(i) != str.charAt(i % str.length())) return false;
        }
        return true;
    }
}