package Leetcode_347_Top_K_Frequent_Elements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution2 {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> heap = new PriorityQueue((a, b) -> map.get(a) - map.get(b));
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for(int key : map.keySet()){
            heap.offer(key);
            if(heap.size() > k) heap.poll();
        }
        for(int i = k - 1; i >= 0; i--){
            ans[i] = heap.poll();
        }
        return ans;
    }
}
