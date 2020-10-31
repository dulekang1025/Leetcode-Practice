package Leetcode_1636_Sort_Array_by_Increasing_Frequency;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        Queue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(a).equals(map.get(b)) ? b - a : map.get(a) - map.get(b));
        for(int k : map.keySet()){
            heap.offer(k);
        }
        int[] ans = new int[nums.length];
        int i = 0;
        while(!heap.isEmpty()){
            int temp = heap.poll();
            for(int j = 0; j < map.get(temp); j++){
                ans[i++] = temp;
            }
        }
        return ans;
    }
}
