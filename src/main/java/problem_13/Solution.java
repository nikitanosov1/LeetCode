package problem_13;

class Solution {
    public int romanToInt(String s) {
        s += " ";
        int result = 0;
        char prevChar = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            switch (prevChar){
                case 'I':
                    if (currentChar == 'V' || currentChar == 'X') {
                        result -= 1;
                    }else{
                        result += 1;
                    }
                    break;
                case 'V':
                    result += 5;
                    break;
                case 'X':
                    if (currentChar == 'L' || currentChar == 'C') {
                        result -= 10;
                    }else{
                        result += 10;
                    }
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'C':
                    if (currentChar == 'D' || currentChar == 'M') {
                        result -= 100;
                    }else{
                        result += 100;
                    }
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'M':
                    result += 1_000;
                    break;
            }
            prevChar = currentChar;
        }
        return result;
    }
}