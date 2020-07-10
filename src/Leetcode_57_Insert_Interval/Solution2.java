package Leetcode_57_Insert_Interval;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int i = 0;
        // find the first interval whose end time is later than the new interval's start time
        while(i < intervals.length && intervals[i][1] < newInterval[0]){
            list.add(intervals[i]);
            i++;
        }
        // find the first interval whose start time is later than new interval's end time
        while(i < intervals.length && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        list.add(newInterval);
        while(i < intervals.length){
            list.add(intervals[i]);
            i++;
        }
        int[][] ans = new int[list.size()][2];
        for(int j = 0; j < ans.length; j++){
            ans[j] = list.get(j);
        }
        return ans;
    }
}
