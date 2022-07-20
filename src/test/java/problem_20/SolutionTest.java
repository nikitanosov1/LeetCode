package problem_20;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @ParameterizedTest(name = "{index} - {0} answer need to be {1}")
    @CsvSource(value = {
            "(), true",
            "()[]{}, true",
            "(], false",
            "([{}]), true",
            "([{})], false",
            "[, false"
    })
    void isValid(String input, boolean output) {
        assertEquals(new Solution().isValid(input), output);
    }
}