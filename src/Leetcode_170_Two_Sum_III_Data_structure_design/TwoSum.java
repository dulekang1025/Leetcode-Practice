package Leetcode_170_Two_Sum_III_Data_structure_design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class TwoSum {

    List<Integer> list;
    boolean is_sorted;

    /** Initialize your data structure here. */
    public TwoSum() {
        list = new ArrayList<>();
        is_sorted = false;
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        list.add(number);
        is_sorted = false;
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        if(!is_sorted){
            Collections.sort(list);
        }
        int left = 0, right = list.size() - 1;
        while(left < right){
            int temp = list.get(left) + list.get(right);
            if(temp > value){
                right--;
            }else if(temp < value){
                left++;
            }else{
                return true;
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
