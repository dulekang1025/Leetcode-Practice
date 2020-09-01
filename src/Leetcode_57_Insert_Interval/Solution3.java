package Leetcode_57_Insert_Interval;

import java.util.ArrayList;
import java.util.List;

class Solution3 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int i = 0;
        // if cur interval's end time is smaller than newInterval's end time
        // just add it to the result list.
        while(i < intervals.length && intervals[i][1] < newInterval[0]){
            list.add(intervals[i]);
            i++;
        }
        // now cur interval's end time is equal or greater than newInterval's start time
        // update the newInterval's start time
        if(i < intervals.length) newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
        // looping through rest intervals and keep updating newInterval's end time
        // until cur interval's start time is greater than newInterval's end time
        while(i < intervals.length && intervals[i][0] <= newInterval[1]){
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        // add newInterval to the result list
        list.add(newInterval);
        // add rest intervals
        while(i < intervals.length){
            list.add(intervals[i]);
            i++;
        }
        return list.toArray(new int[list.size()][2]);
    }
}
