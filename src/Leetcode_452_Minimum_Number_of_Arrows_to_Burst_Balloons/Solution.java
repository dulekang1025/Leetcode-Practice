package Leetcode_452_Minimum_Number_of_Arrows_to_Burst_Balloons;

import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;
        int res = 1;
        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        int[] cur = points[0];
        for(int i = 1; i < points.length; i++){
            if(cur[1] >= points[i][0]){
                continue;
            }else{
                res++;
                cur = points[i];
            }
        }
        return res;
    }
}
