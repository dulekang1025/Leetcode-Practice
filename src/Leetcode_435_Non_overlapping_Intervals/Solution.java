package Leetcode_435_Non_overlapping_Intervals;

import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int res = 0;
        if(intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int[] cur = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            if(cur[1] > intervals[i][0]){
                res++;
            }else{
                cur = intervals[i];
            }
        }
        return res;
    }
}
