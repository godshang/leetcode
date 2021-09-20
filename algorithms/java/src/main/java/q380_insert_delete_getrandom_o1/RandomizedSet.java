package q380_insert_delete_getrandom_o1;

import java.util.*;

public class RandomizedSet {
    
    private List<Integer> list;
    private Map<Integer, Integer> valToIndexMap;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        valToIndexMap = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (valToIndexMap.containsKey(val)) return false;
        valToIndexMap.put(val, list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!valToIndexMap.containsKey(val)) return false;
        int index = valToIndexMap.get(val);
        int lastEle = list.get(list.size() - 1);
        valToIndexMap.put(lastEle, index);
        swap(index, list.size() - 1);
        list.remove(list.size() - 1);
        valToIndexMap.remove(val);
        return true;
    }
    
    private void swap(int i, int j) {
        int tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        int i = random.nextInt(list.size());
        return list.get(i);
    }
}
