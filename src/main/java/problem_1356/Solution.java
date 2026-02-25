package problem_1356;
/*
 * @author Nikita Nosov
 * Date: 2/25/2026
 */

import java.util.Arrays;

class Solution {
    public int[] sortByBits(int[] arr) {
        return Arrays.stream(arr)
                .boxed()
                .sorted((a, b) -> {
                    int bitsA = Integer.bitCount(a);
                    int bitsB = Integer.bitCount(b);
                    return (bitsA == bitsB) ? Integer.compare(a, b) : Integer.compare(bitsA, bitsB);
                })
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
