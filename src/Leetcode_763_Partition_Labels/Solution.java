package Leetcode_763_Partition_Labels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < S.length(); i++){
            map.put(S.charAt(i), i);
        }
        int start = 0;
        int end = 0;
        for(int i = 0; i < S.length(); i++){
            end = Math.max(end, map.get(S.charAt(i)));
            if(end == i){
                list.add(end - start + 1);
                start = end + 1;
            }
        }
        return list;
    }
}