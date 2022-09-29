package problem_658;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void findClosestElements_1() {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int k = 4;
        int x = 3;
        List<Integer> expected = List.of(1, 2, 3, 4);
        assertEquals(expected, new Solution().findClosestElements(arr, k, x));
    }

    @Test
    void findClosestElements_2() {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int k = 4;
        int x = -1;
        List<Integer> expected = List.of(1, 2, 3, 4);
        assertEquals(expected, new Solution().findClosestElements(arr, k, x));
    }
}