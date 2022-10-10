package problem_1328;

class Solution {
    public String breakPalindrome(String palindrome) {
        if (palindrome.length() == 1) return "";

        StringBuilder ans = new StringBuilder(palindrome);
        for (int i = 0; i < palindrome.length() / 2; ++i) {
            if (palindrome.charAt(i) != 'a') {
                ans.setCharAt(i, 'a');
                return ans.toString();
            }
        }
        ans.setCharAt(palindrome.length() - 1, 'b');
        return ans.toString();
    }
}