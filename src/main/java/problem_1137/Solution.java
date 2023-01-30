package problem_1137;

class Solution {
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        int first = 0;
        int second = 1;
        int third = 1;
        while (n-- > 2) {
            int temp = third;
            third = first + second + third;
            first = second;
            second = temp;
        }
        return third;
    }
}