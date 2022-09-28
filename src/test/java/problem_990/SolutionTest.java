package problem_990;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void equationsPossible_1() {
        String[] equations = new String[]{"a==b", "b!=a"};
        boolean expected = false;
        assertEquals(expected, new Solution().equationsPossible(equations));
    }

    @Test
    void equationsPossible_2() {
        String[] equations = new String[]{"b==a","a==b"};
        boolean expected = true;
        assertEquals(expected, new Solution().equationsPossible(equations));
    }

    @Test
    void equationsPossible_3() {
        String[] equations = new String[]{"a==b", "c==e", "b==c", "a!=e"};
        boolean expected = false;
        assertEquals(expected, new Solution().equationsPossible(equations));
    }

    //["a==z","a==b","b==c","c==d","b==y","c==x","d==w","g==h","h==i","i==j","a==g","j!=y"]
    @Test
    void equationsPossible_4() {
        String[] equations = new String[]{"a==z","a==b","b==c","c==d","b==y","c==x","d==w","g==h","h==i","i==j","a==g","j!=y"};
        boolean expected = false;
        assertEquals(expected, new Solution().equationsPossible(equations));
    }
}