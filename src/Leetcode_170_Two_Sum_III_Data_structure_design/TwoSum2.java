package Leetcode_170_Two_Sum_III_Data_structure_design;

import java.util.HashMap;
import java.util.Map;

class TwoSum2 {

    Map<Integer, Integer> map;

    /** Initialize your data structure here. */
    public TwoSum2() {
        this.map = new HashMap<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(int key : map.keySet()){
            int target = value - key;
            if(target != key && map.containsKey(target)){
                return true;
            }else{
                if(map.containsKey(target) && map.get(target) > 1){
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
