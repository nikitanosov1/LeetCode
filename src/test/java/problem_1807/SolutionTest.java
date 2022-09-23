package problem_1807;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void evaluate_1() {
        String s = "(name)is(age)yearsold";
        List<List<String>> knowledge =
                List.of(List.of("name", "bob"),
                List.of("age","two"));
        String expected = "bobistwoyearsold";
        assertEquals(expected, new Solution().evaluate(s, knowledge));
    }
}