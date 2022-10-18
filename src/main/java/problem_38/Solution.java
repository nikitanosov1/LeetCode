package problem_38;

class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String prevCountAndSay = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        char lastChar = prevCountAndSay.charAt(0);
        int countOfLastChar = 1;
        for (int i = 1; i < prevCountAndSay.length(); ++i) {
            if (prevCountAndSay.charAt(i) == lastChar) {
                ++countOfLastChar;
            } else {
                sb.append(Integer.toString(countOfLastChar)).append(lastChar);
                countOfLastChar = 1;
                lastChar = prevCountAndSay.charAt(i);
            }
        }
        sb.append(Integer.toString(countOfLastChar)).append(lastChar);
        return sb.toString();
    }
}