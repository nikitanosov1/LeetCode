package problem_35;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void searchInsert_1() {
        assertEquals(new Solution().searchInsert(new int[]{1,3,5,6}, 5), 2);
    }

    @Test
    void searchInsert_2() {
        assertEquals(new Solution().searchInsert(new int[]{1,3,5,6}, 2), 1);
    }

    @Test
    void searchInsert_3() {
        assertEquals(new Solution().searchInsert(new int[]{1,3,5,6}, 7), 4);
    }

    @Test
    void searchInsert_4() {
        assertEquals(new Solution().searchInsert(new int[]{1,3,5,6}, 0), 0);
    }
}