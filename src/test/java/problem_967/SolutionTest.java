package problem_967;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void numsSameConsecDiff_1() {
        int n = 3;
        int k = 7;
        int[] expected = new int[]{181,292,707,818,929};
        List<Integer> first = Arrays.stream(expected).boxed().toList();
        List<Integer> second = Arrays.stream(new Solution().numsSameConsecDiff(n, k)).boxed().toList();

        assertTrue(first.size() == second.size() && first.containsAll(second) && second.containsAll(first));
    }

    @Test
    void numsSameConsecDiff_2() {
        int n = 2;
        int k = 1;
        int[] expected = new int[]{10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98};

        List<Integer> first = Arrays.stream(expected).boxed().toList();
        List<Integer> second = Arrays.stream(new Solution().numsSameConsecDiff(n, k)).boxed().toList();

        assertTrue(first.size() == second.size() && first.containsAll(second) && second.containsAll(first));
    }
}