package Leetcode_1288_Remove_Covered_Intervals;

import java.util.Arrays;

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        // Interval [a,b) is covered by interval [c,d) if and only if c <= a and b <= d.
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] prev = null;
        int count = 0;
        for(int i = 0; i < intervals.length; i++){
            if(prev == null){
                prev = intervals[i];
                count++;
            }else{
                int[] cur = intervals[i];
                if(prev[0] <= cur[0] && cur[1] <= prev[1]){
                    continue;
                }else{
                    prev = cur;
                    count++;
                }
            }
        }
        return count;
    }
}
