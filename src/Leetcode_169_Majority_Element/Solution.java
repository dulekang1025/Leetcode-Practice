package Leetcode_169_Majority_Element;

import java.util.HashMap;

class Solution {
    public int majorityElement(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int times = (nums.length % 2 > 0) ? (nums.length / 2) + 1 : nums.length / 2;
        for(int i : nums){
            if(map.containsKey(i)) {
                int temp = map.get(i);
                temp += 1;
                map.put(i, temp);
            }
            else map.put(i, 1);
            if(map.get(i) > times){
                res = i;
                break;
            }
        }
        return res;
    }
}
