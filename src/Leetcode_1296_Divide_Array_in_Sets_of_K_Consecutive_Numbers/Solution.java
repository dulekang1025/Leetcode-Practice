package Leetcode_1296_Divide_Array_in_Sets_of_K_Consecutive_Numbers;

import java.util.TreeMap;

class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length % k != 0) return false;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int n : nums){
            if(!map.containsKey(n)){
                map.put(n, 1);
            }else{
                map.replace(n, map.get(n) + 1);
            }
        }
        while(map.size() > 0){
            int first = map.firstKey();
            for(int i = 0; i < k; i++){
                int cur = first + i;
                if(!map.containsKey(cur)) return false;
                int count = map.get(cur);
                if(count == 1) map.remove(cur);
                else map.replace(cur, count - 1);
            }
        }
        return true;
    }
}
