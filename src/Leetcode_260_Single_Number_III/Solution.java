package Leetcode_260_Single_Number_III;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for(int key : map.keySet()){
            if(map.get(key) == 1) list.add(key);
        }
        int[] ans = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}
