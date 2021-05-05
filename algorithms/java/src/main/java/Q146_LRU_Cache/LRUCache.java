package q146_lru_cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private Map<Integer, Entry> map = new HashMap<>();
    private Entry first, last;
    private int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        Entry entry = map.get(key);
        makeRecently(entry);
        return entry.val;
    }

    public void put(int key, int value) {
        Entry entry = map.get(key);
        if (entry == null) {
            if (map.size() >= capacity) {
                removeOldest();
            }
            entry = new Entry();
            entry.key = key;
        }
        entry.val = value;
        map.put(key, entry);
        makeRecently(entry);
    }
    
    private void makeRecently(Entry entry) {
        remove(entry);
        addFirst(entry);
    }
    
    private void remove(Entry entry) {
        if (entry == null) return;
        if (entry.prev != null) entry.prev.next = entry.next;
        if (entry.next != null) entry.next.prev = entry.prev;
        if (entry == first) first = entry.next;
        if (entry == last) last = entry.prev;
    }
    
    private void addFirst(Entry entry) {
        if (first == null || last == null) {
            first = last = entry;
        } else {
            entry.next = first;
            entry.prev = null;
            first.prev = entry;
            first = entry;
        }
    }
    
    private void removeOldest() {
        map.remove(last.key);
        remove(last);
    }
    
    private class Entry {
        Entry prev, next;
        int key, val;
    }
}
