package Leetcode_1436_Destination_City;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String, Integer> map = new HashMap<>();
        String res = "";
        for(List<String> path : paths){
            String out = path.get(0);
            String in = path.get(1);
            map.put(out, map.getOrDefault(out, 0) - 1);  // out -1
            map.put(in, map.getOrDefault(in, 0) + 1);    // in +1
        }
        for(String city : map.keySet()){
            if(map.get(city) > 0)
                res = city;
        }
        return res;
    }
}
