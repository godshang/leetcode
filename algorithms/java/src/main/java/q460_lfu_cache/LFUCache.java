package q460_lfu_cache;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {
    
    private Map<Integer, Integer> keyToValMap;
    private Map<Integer, Integer> keyToFreqMap;
    private Map<Integer, LinkedHashSet<Integer>> freqToKeysMap;
    private int capacity;
    private int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.keyToValMap = new HashMap<>();
        this.keyToFreqMap = new HashMap<>();
        this.freqToKeysMap = new HashMap<>();
    }

    public int get(int key) {
        if (!keyToValMap.containsKey(key)) {
            return -1;
        }
        increaseFreq(key);
        return keyToValMap.get(key);
    }

    public void put(int key, int value) {
        if (keyToValMap.containsKey(key)) {
            keyToValMap.put(key, value);
            increaseFreq(key);
            return;
        }
        
        if (keyToValMap.size() >= this.capacity) {
            removeMinFreqKey();
        }
        
        if (keyToValMap.size() < this.capacity) {
            keyToValMap.put(key, value);
            keyToFreqMap.put(key, 1);
            freqToKeysMap.putIfAbsent(1, new LinkedHashSet<>());
            freqToKeysMap.get(1).add(key);
            this.minFreq = 1;
        }
    }
    
    private void removeMinFreqKey() {
        LinkedHashSet<Integer> keys = freqToKeysMap.get(minFreq);
        if (keys == null) return;
        int removedKey = keys.iterator().next();
        keys.remove(removedKey);
        if (keys.isEmpty()) {
            freqToKeysMap.remove(minFreq);
        }
        keyToFreqMap.remove(removedKey);
        keyToValMap.remove(removedKey);
    }
    
    private void increaseFreq(int key) {
        int freq = keyToFreqMap.get(key);
        keyToFreqMap.put(key, freq + 1);
        
        freqToKeysMap.get(freq).remove(key);
        freqToKeysMap.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freqToKeysMap.get(freq + 1).add(key);
        if (freqToKeysMap.get(freq).isEmpty()) {
            freqToKeysMap.remove(freq);
            if (freq == minFreq) {
                this.minFreq++;
            }
        }
    }
}
