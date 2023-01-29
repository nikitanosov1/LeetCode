package problem_460;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

class LFUCache {
    private int capacity;
    // just key-value storage
    private Map<Integer, Integer> cache = new HashMap<>();

    // key-count storage;
    private Map<Integer, Integer> keyCounts = new HashMap<>();

    // key - it's frequency, value - it's List of Keys with this frequency
    private Map<Integer, LinkedHashSet<Integer>> freqMap = new HashMap<>();
    private int minFrequencyInFreqMap = -1;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        freqMap.put(1, new LinkedHashSet<>());
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        freqMap.get(keyCounts.get(key)).remove(key);
        if (freqMap.get(minFrequencyInFreqMap).size() == 0) {
            minFrequencyInFreqMap++;
        }
        freqMap.computeIfAbsent(keyCounts.get(key) + 1, val -> new LinkedHashSet<>()).add(key);

        keyCounts.put(key, keyCounts.get(key) + 1);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (capacity <= 0) return;
        if (cache.containsKey(key)) {
            cache.put(key, value);
            freqMap.get(keyCounts.get(key)).remove(key);
            if (freqMap.get(minFrequencyInFreqMap).size() == 0) {
                minFrequencyInFreqMap++;
            }
            freqMap.computeIfAbsent(keyCounts.get(key) + 1, val -> new LinkedHashSet<>()).add(key);

            keyCounts.put(key, keyCounts.get(key) + 1);
        } else {
            if (cache.size() == capacity) {
                // need to delete least recently used key
                int keyToDelete = freqMap.get(minFrequencyInFreqMap).iterator().next();
                freqMap.get(minFrequencyInFreqMap).remove(keyToDelete);
                keyCounts.remove(keyToDelete);
                cache.remove(keyToDelete);
            }
            // need to add the new key-value
            minFrequencyInFreqMap = 1;
            cache.put(key, value);
            keyCounts.put(key, 1);
            freqMap.computeIfAbsent(1, val -> new LinkedHashSet<>()).add(key);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */