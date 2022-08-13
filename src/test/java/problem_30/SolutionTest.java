package problem_30;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void findSubstring_1() {
        String s = "barfoothefoobarman";
        String[] words = new String[]{
                "foo",
                "bar"
        };

        List<Integer> expected = new LinkedList<>();
        expected.add(0);
        expected.add(9);
        assertEquals(expected, new Solution().findSubstring(s, words));
    }

    @Test
    void findSubstring_2() {
        String s = "wordgoodgoodgoodbestword";
        String[] words = new String[]{
                "word",
                "good",
                "best",
                "word"
        };

        List<Integer> expected = new LinkedList<>();
        assertEquals(expected, new Solution().findSubstring(s, words));
    }

    @Test
    void findSubstring_3() {
        String s = "barfoofoobarthefoobarman";
        String[] words = new String[]{
                "bar",
                "foo",
                "the"
        };

        List<Integer> expected = new LinkedList<>();
        expected.add(6);
        expected.add(9);
        expected.add(12);
        assertEquals(expected, new Solution().findSubstring(s, words));
    }
}