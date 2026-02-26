package problem_1404;
/*
 * @author Nikita Nosov
 * Date: 2/26/2026
 */

class Solution {
    public int numSteps(String s) {
        char[] arr = s.toCharArray();
        int realLength = s.length();
        int result = 0;

        while (realLength > 1) {
            if (arr[realLength - 1] == '0') {
                --realLength;
            } else {
                boolean isOneAdded = false;
                for (int i = realLength - 1; i > -1; --i) {
                    if (isOneAdded) {
                        break;
                    }
                    if (arr[i] == '0') {
                        arr[i] = '1';
                        isOneAdded = true;
                    } else {
                        arr[i] = '0';
                    }
                }
                if (!isOneAdded) {
                    ++realLength;
                    arr = new char[realLength];
                    arr[0] = '1';
                    for (int i = 1; i < realLength; ++i) {
                        arr[i] = '0';
                    }
                }
            }
            ++result;
        }
        return result;
    }
}
