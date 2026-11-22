package lc380_Insert_Delete_GetRandom_O_1;

import java.util.*;

// LeetCode 380. Insert Delete GetRandom O 1
class RandomizedSet {
    private Map<Integer, Integer> mp;
    private List<Integer> arr;
    private Random rand = new Random();

    public RandomizedSet() {
        mp = new HashMap<>();
        arr = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (mp.containsKey(val)) {
            return false;
        }
        mp.put(val, arr.size());
        arr.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!mp.containsKey(val)) {
            return false;
        }
        int idx = mp.get(val);
        if (idx < arr.size() - 1) {
            int lastVal = arr.get(arr.size() - 1);
            arr.set(idx, lastVal);
            mp.put(lastVal, idx);
        }
        mp.remove(val);
        arr.remove(arr.size() - 1);
        return true;
    }

    public int getRandom() {
        return arr.get(rand.nextInt(arr.size()));
    }
}
