package Leetcode_454_4Sum_II.Solution;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int a : A){
            for(int b : B){
                map.put(a + b, map.getOrDefault(a + b, 0) + 1);
            }
        }
        for(int c : C){
            for(int d : D){
                count += map.getOrDefault(-(c + d), 0);
            }
        }
        return count;
    }
}
