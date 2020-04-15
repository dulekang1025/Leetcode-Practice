package Leetcode_692_Top_K_Frequent_Words;

import java.util.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        List<String> ans = new ArrayList<>();
        Queue<Map.Entry<String, Integer>> pq = new PriorityQueue<>
                ((a,b) -> a.getValue() != b.getValue() ? a.getValue() - b.getValue() : b.getKey().compareTo(a.getKey()));
        for(String s : words){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            pq.add(entry);
        }
        while(pq.size() > k){
            pq.poll();
        }
        System.out.println(pq);
        while(k > 0){
            ans.add(0, pq.poll().getKey());
            k--;
        }
        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        String[] words = new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        s.topKFrequent(words, 4);
    }
}
