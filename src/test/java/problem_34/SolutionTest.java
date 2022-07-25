package problem_34;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("argsForSearchRange")
    void searchRange(int[] nums, int target, int[] expected) {
        assertArrayEquals(new Solution().searchRange(nums, target), expected);
    }

    private static Stream<Arguments> argsForSearchRange(){
        return Stream.of(
                Arguments.of(new int[]{5, 7, 7, 8, 8, 10}, 8, new int[]{3, 4}),
                Arguments.of(new int[]{5, 7, 7, 8, 8, 10}, 6, new int[]{-1, -1}),
                Arguments.of(new int[]{}, 0, new int[]{-1, -1}),
                Arguments.of(new int[]{5, 5, 5, 5, 5}, 5, new int[]{0, 4}),
                Arguments.of(new int[]{5, 5, 5, 5, 5}, 6, new int[]{-1, -1}),
                Arguments.of(new int[]{5, 7, 7, 7, 7, 10}, 7, new int[]{1, 4})
        );
    }

    @ParameterizedTest
    @MethodSource("argsForRightBinSearch")
    void rightBinSearch(int[] nums, int target, int expected) {
        assertEquals(new Solution().rightBinSearch(nums, target), expected);
    }

    private static Stream<Arguments> argsForRightBinSearch(){
        return Stream.of(
                Arguments.of(new int[]{1, 2, 2, 3, 3, 3, 4}, -100, -1),
                Arguments.of(new int[]{1, 2, 2, 3, 3, 3, 4}, 0, -1),
                Arguments.of(new int[]{1, 2, 2, 3, 3, 3, 4}, 1, 0),
                Arguments.of(new int[]{1, 2, 2, 3, 3, 3, 4}, 2, 2),
                Arguments.of(new int[]{1, 2, 2, 3, 3, 3, 4}, 3, 5),
                Arguments.of(new int[]{1, 2, 2, 3, 3, 3, 4}, 4, 6),
                Arguments.of(new int[]{1, 2, 2, 3, 3, 3, 4}, 5, -1),
                Arguments.of(new int[]{1, 2, 2, 3, 3, 3, 4}, 100, -1),
                Arguments.of(new int[]{}, 5, -1),
                Arguments.of(new int[]{1, 1, 1, 1, 1, 1, 1, 1}, 2, -1)
                );
    }

    @ParameterizedTest
    @MethodSource("argsForLeftBinSearch")
    void leftBinSearch(int[] nums, int target, int expected) {
        assertEquals(new Solution().leftBinSearch(nums, target), expected);
    }

    private static Stream<Arguments> argsForLeftBinSearch(){
        return Stream.of(
                Arguments.of(new int[]{1, 2, 2, 3, 3, 3, 4}, -100, -1),
                Arguments.of(new int[]{1, 2, 2, 3, 3, 3, 4}, 0, -1),
                Arguments.of(new int[]{1, 2, 2, 3, 3, 3, 4}, 1, 0),
                Arguments.of(new int[]{1, 2, 2, 3, 3, 3, 4}, 2, 1),
                Arguments.of(new int[]{1, 2, 2, 3, 3, 3, 4}, 3, 3),
                Arguments.of(new int[]{1, 2, 2, 3, 3, 3, 4}, 4, 6),
                Arguments.of(new int[]{1, 2, 2, 3, 3, 3, 4}, 5, -1),
                Arguments.of(new int[]{1, 2, 2, 3, 3, 3, 4}, 100, -1),
                Arguments.of(new int[]{}, 5, -1),
                Arguments.of(new int[]{1, 1, 1, 1, 1, 1, 1, 1}, 2, -1)
        );
    }
}