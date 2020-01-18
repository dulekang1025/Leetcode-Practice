package Leetcode_217_Contains_Duplicate;

import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        if(set.size() == nums.length) return false;
        else return true;
    }
}
