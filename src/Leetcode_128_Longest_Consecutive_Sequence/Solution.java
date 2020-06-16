package Leetcode_128_Longest_Consecutive_Sequence;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums) set.add(n);
        int max = 0;
        int cur = 0;
        for(int n : nums){
            if(!set.contains(n - 1)){
                cur = n;
                int res = 1;
                while(set.contains(cur + 1)){
                    res++;
                    cur += 1;
                }
                max = Math.max(max, res);
            }
        }
        return max;
    }
}
