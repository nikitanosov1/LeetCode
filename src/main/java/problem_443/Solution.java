package problem_443;

class Solution {
    public int compress(char[] chars) {
        int countOfChars = 1;
        int newLength = 0;
        for (int i = 1; i < chars.length; ++i) {
            if (chars[i] != chars[i - 1]) {
                chars[newLength] = chars[i - 1];
                ++newLength;
                if (countOfChars != 1) {
                    char[] arrayOfCountOfChars = Integer.toString(countOfChars).toCharArray();
                    for (int j = 0; j < arrayOfCountOfChars.length; ++j) {
                        chars[newLength] = arrayOfCountOfChars[j];
                        ++newLength;
                    }
                }
                countOfChars = 1;
            } else {
                ++countOfChars;
            }
        }
        chars[newLength] = chars[chars.length - 1];
        ++newLength;
        if (countOfChars != 1) {
            char[] arrayOfCountOfChars = Integer.toString(countOfChars).toCharArray();
            for (int j = 0; j < arrayOfCountOfChars.length; ++j) {
                chars[newLength] = arrayOfCountOfChars[j];
                ++newLength;
            }
        }
        return newLength;
    }
}