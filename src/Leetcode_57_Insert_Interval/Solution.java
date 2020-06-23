package Leetcode_57_Insert_Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] ans = new int[intervals.length + 1][2];
        int k = 0;
        while(k < intervals.length){
            ans[k] = intervals[k];
            k++;
        }
        ans[k] = newInterval;
        Arrays.sort(ans, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        int[] prev = new int[2];
        for(int[] inter : ans){
            if(res.isEmpty() || prev[1] < inter[0]) res.add(inter);  // insert interval
            else prev[1] = prev[1] > inter[1] ? prev[1] : inter[1];  // merge intervals
            prev = res.get(res.size() - 1);
        }
        ans = new int[res.size()][2];
        for(int i = 0; i < res.size(); i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}
