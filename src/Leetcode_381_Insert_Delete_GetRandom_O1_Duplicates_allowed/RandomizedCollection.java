package Leetcode_381_Insert_Delete_GetRandom_O1_Duplicates_allowed;

import java.util.*;

class RandomizedCollection {

    Map<Integer, Set<Integer>> map;
    List<Integer> list;
    Random rand;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean has = true;
        if(map.containsKey(val)) has = false;
        map.putIfAbsent(val, new HashSet<>());
        list.add(val);
        map.get(val).add(list.size() - 1);
        return has;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val) || map.get(val).size() == 0){
            return false;
        }
        Set<Integer> set = map.get(val);
        int index = set.iterator().next();
        set.remove(index);
        int last = list.get(list.size() - 1);
        list.set(index, last);
        if(index != list.size() - 1){
            Set<Integer> s = map.get(last);
            s.remove(list.size() - 1);
            s.add(index);
        }
        list.remove(list.size() - 1);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
