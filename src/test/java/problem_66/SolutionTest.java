package problem_66;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


class SolutionTest {

    @ParameterizedTest
    @MethodSource("argsForPlusOne")
    void plusOne(int[] digits, int[] expected) {
        assertArrayEquals(new Solution().plusOne(digits), expected);
    }

    private static Stream<Arguments> argsForPlusOne(){
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, new int[]{1, 2, 4}),
                Arguments.of(new int[]{1, 2, 9}, new int[]{1, 3, 0}),
                Arguments.of(new int[]{9, 9, 9}, new int[]{1, 0, 0, 0}),
                Arguments.of(new int[]{9}, new int[]{1, 0}),
                Arguments.of(new int[]{4, 3, 2, 1}, new int[]{4, 3, 2, 2})
        );
    }
}