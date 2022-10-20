package problem_12;

class Solution {
    public String intToRoman(int num) {
        int[] val = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] code = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            for (int i = 0; i < 13; i++) {
                if (num >= val[i]) {
                    num -= val[i];
                    sb.append(code[i]);
                    break;
                }
            }
        }
        return sb.toString();

        /*
        My second solution (slower)

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");

        map.put(4, "IV");
        map.put(9, "IX");
        map.put(40, "XL");
        map.put(90, "XC");
        map.put(400, "CD");
        map.put(900, "CM");


        StringBuilder sb = new StringBuilder();
        int numLength = 0;
        while (num > 0) {
            ++numLength;
            int lastDigit = num % 10;
            int number =  lastDigit * (int) Math.pow(10, numLength - 1);
            num /= 10;
            if (lastDigit == 4 || lastDigit == 9) {
                sb.insert(0, map.get(number));
                continue;
            }
            while (lastDigit > 5) {
                sb.insert(0, map.get((int) Math.pow(10, numLength - 1)));
                --lastDigit;
            }
            if (lastDigit == 5) {
                sb.insert(0, map.get(5 * (int) Math.pow(10, numLength - 1)));
                continue;
            }
            while (lastDigit > 0) {
                sb.insert(0, map.get((int) Math.pow(10, numLength - 1)));
                --lastDigit;
            }
        }
        return sb.toString();
        */
    }
}