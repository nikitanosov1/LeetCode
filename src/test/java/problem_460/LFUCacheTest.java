package problem_460;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LFUCacheTest {

    @Test
    void lfu_1() {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        assertEquals(1, lfuCache.get(1));
        assertEquals(1, lfuCache.get(1));
        assertEquals(1, lfuCache.get(1));
        assertEquals(2, lfuCache.get(2));
        assertEquals(2, lfuCache.get(2));
        lfuCache.put(3, 3);
        assertEquals(-1, lfuCache.get(2));
        assertEquals(3, lfuCache.get(3));
    }

}