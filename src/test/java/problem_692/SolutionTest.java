package problem_692;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void topKFrequent_1() {
        String[] words = new String[]{"i","love","leetcode","i","love","coding"};
        int k = 2;

        List<String> expected = List.of("i", "love");
        assertEquals(expected, new Solution().topKFrequent(words, k));
    }
}