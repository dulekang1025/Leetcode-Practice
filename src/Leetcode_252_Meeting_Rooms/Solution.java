package Leetcode_252_Meeting_Rooms;

import java.util.Arrays;

class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] prev = null;
        for(int i = 0; i < intervals.length; i++){
            if(prev != null){
                if(prev[1] > intervals[i][0]){
                    return false;
                }
            }
            prev = intervals[i];
        }
        return true;
    }
}
