package Leetcode_56_Merge_Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
        List<int[]> res = new ArrayList<>();
        int[] prev = new int[2];
        for(int[] interval : intervals){
            if(res.isEmpty() || prev[1] < interval[0]) res.add(interval);
            else prev[1] = prev[1] > interval[1] ? prev[1] : interval[1];
            prev = res.get(res.size() - 1);
        }
        int[][] ans = new int[res.size()][2];
        for(int i = 0; i < res.size(); i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}