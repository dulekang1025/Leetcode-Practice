package Leetcode_1496_Path_Crossing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public boolean isPathCrossing(String path) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.putIfAbsent(0, new ArrayList<Integer>());
        map.get(0).add(0);
        int[] pre = new int[]{0, 0};
        int[] cur;
        for(char c : path.toCharArray()){
            if(c == 'N'){
                cur = new int[]{pre[0], pre[1] + 1};
            }else if(c == 'S'){
                cur = new int[]{pre[0], pre[1] - 1};
            }else if(c == 'E'){
                cur = new int[]{pre[0] + 1, pre[1]};
            }else{
                cur = new int[]{pre[0] - 1, pre[1]};
            }
            if(map.containsKey(cur[0])){
                if(map.get(cur[0]).contains(cur[1])){
                    return true;
                }
            }
            map.putIfAbsent(cur[0], new ArrayList<Integer>());
            map.get(cur[0]).add(cur[1]);
            pre = cur;
        }
        return false;
    }
}
