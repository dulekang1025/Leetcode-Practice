package Leetcode_1488_Avoid_Flood_in_The_City;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class Solution {
    public int[] avoidFlood(int[] rains) {
        Map<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>();
        int[] res = new int[rains.length];
        Arrays.fill(res, -1);
        for(int i = 0; i < rains.length; i++){
            if(rains[i] == 0){
                set.add(i);
                res[i] = 1;
            }else{
                int count = map.getOrDefault(rains[i], -1);
                if(count != -1){
                    Integer sunnyDay = set.ceiling(count);
                    if(sunnyDay == null) return new int[]{};
                    res[sunnyDay] = rains[i];
                    set.remove(sunnyDay);
                }
                map.put(rains[i], i);
            }
        }
        return res;
    }
}
