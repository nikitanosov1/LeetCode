package problem_7;

class Solution {
    public int reverse(int x) {
        boolean isNegative = false;
        if (x < 0){
            isNegative = true;
            x = -x;
        }
        String reverseX = new StringBuilder(Integer.toString(x)).reverse().toString();
        try {
            x = Integer.parseInt(reverseX);
            if (isNegative) x = -x;
            return x;
        } catch (Exception e) {
            return 0;
        }
    }
}