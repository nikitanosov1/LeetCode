package problem_557;

class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder answer = new StringBuilder();
        for (String word : words) {
            answer.append(new StringBuilder(word).reverse()).append(" ");
        }
        return answer.deleteCharAt(answer.length() - 1).toString();
    }
}