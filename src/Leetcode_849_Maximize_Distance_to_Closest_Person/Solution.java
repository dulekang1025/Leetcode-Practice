package Leetcode_849_Maximize_Distance_to_Closest_Person;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int maxDistToClosest(int[] seats) {
        List<Integer> list = new ArrayList<>();
        int ans = 0;
        int len = seats.length;
        for(int i = 0; i < len; i++){
            if(seats[i] == 1) list.add(i);
        }
        ans = Math.max(list.get(0), len - list.get(list.size() - 1) - 1);
        for(int i = 0; i < list.size() - 1; i++){
            ans = Math.max(ans, (list.get(i + 1) - list.get(i)) / 2);
        }
        return ans;
    }
}
