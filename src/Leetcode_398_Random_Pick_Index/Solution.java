package Leetcode_398_Random_Pick_Index;

import java.util.*;

class Solution {

    Map<Integer, List<Integer>> map = new HashMap<>();
    Random rand = new Random();

    public Solution(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
    }

    public int pick(int target) {
        List<Integer> list = map.get(target);
        int x = rand.nextInt(list.size());
        return list.get(x);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
