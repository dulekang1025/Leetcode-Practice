package Leetcode_347_Top_K_Frequent_Elements;

import java.util.*;

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> (a.getValue() - b.getValue()));
        for(Map.Entry<Integer, Integer> m : map.entrySet()){
            if(pq.size() < k) pq.add(m);
            else{
                int temp = pq.peek().getValue();
                if(temp < m.getValue()){
                    pq.poll();
                    pq.add(m);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < k; i++){
            ans.add(pq.poll().getKey());
        }
        return ans;
    }
}
