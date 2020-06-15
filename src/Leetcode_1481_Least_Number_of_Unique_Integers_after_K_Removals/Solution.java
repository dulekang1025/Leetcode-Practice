package Leetcode_1481_Least_Number_of_Unique_Integers_after_K_Removals;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for(int n : arr){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.add(entry);
        }
        System.out.println(pq);
        while(k > 0){
            int temp = pq.peek().getValue();
            System.out.println(temp);
            if(k < temp) break;
            k -= temp;
            pq.poll();
        }
        return pq.size();
    }
}