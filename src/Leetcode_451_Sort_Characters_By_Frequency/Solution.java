package Leetcode_451_Sort_Characters_By_Frequency;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public String frequencySort(String s) {
        Queue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>
                ((a, b) -> b.getValue() - a.getValue());
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            pq.add(entry);
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Map.Entry<Character, Integer> entry = pq.poll();
            char key = entry.getKey();
            int val = entry.getValue();
            for(int i = 0; i < val; i++){
                sb.append(key);
            }
        }
        return sb.toString();
    }
}
