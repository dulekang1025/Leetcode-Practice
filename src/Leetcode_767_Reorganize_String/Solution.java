package Leetcode_767_Reorganize_String;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public String reorganizeString(String S) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : S.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Queue<Pair<Character, Integer>> heap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for(char key : map.keySet()){
            heap.offer(new Pair<>(key, map.get(key)));
        }
        StringBuilder sb = new StringBuilder();
        while(heap.size() >= 2){
            Pair<Character, Integer> first = heap.poll();
            Pair<Character, Integer> second = heap.poll();
            sb.append(first.getKey());
            sb.append(second.getKey());
            if(first.getValue() - 1 > 0)
                heap.offer(new Pair<>(first.getKey(), first.getValue() - 1));
            if(second.getValue() - 1 > 0)
                heap.offer(new Pair<>(second.getKey(), second.getValue() - 1));
        }
        while(heap.size() >= 1){
            Pair<Character, Integer> pair = heap.poll();
            if(pair.getValue() > 1) return "";
            sb.append(pair.getKey());
        }
        return sb.toString();
    }
}
