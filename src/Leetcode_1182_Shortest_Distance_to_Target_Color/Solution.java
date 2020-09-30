package Leetcode_1182_Shortest_Distance_to_Target_Color;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < colors.length; i++){
            map.putIfAbsent(colors[i], new ArrayList<>());
            map.get(colors[i]).add(i);
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < queries.length; i++){
            int index = queries[i][0];
            int color = queries[i][1];
            if(map.containsKey(color)){
                List<Integer> list = map.get(color);
                res.add(bs(list, index));
            }else{
                res.add(-1);
            }
        }
        return res;
    }
    private int bs(List<Integer> list, int target){
        // find the first number that greater than target
        int low = 0, high = list.size() - 1;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(list.get(mid) < target){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        int ans = low;
        if(ans - 1 >= 0 && Math.abs(list.get(ans) - target) > Math.abs(list.get(ans - 1) - target)){
            ans = low - 1;
        }
        return Math.abs(list.get(ans) - target);
    }
}

// [1,1,2,1,3,2,2,3,3]
// [[1,3],[2,2],[6,1]]
// [1,2]
// [[0,3]]
// [2,1,2,2,1]
// [[1,1],[4,3],[1,3],[4,2],[2,1]]
