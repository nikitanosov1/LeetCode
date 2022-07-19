package problem_118;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void generate_1() {
        int input = 5;
        List<List<Integer>> output = new ArrayList<>();
        output.add(List.of(1));
        output.add(List.of(1, 1));
        output.add(List.of(1, 2, 1));
        output.add(List.of(1, 3, 3, 1));
        output.add(List.of(1, 4, 6, 4, 1));
        assertEquals(new Solution().generate(input), output);
    }

    @Test
    void generate_2() {
        int input = 1;
        List<List<Integer>> output = new ArrayList<>();
        output.add(List.of(1));
        assertEquals(new Solution().generate(input), output);
    }
}