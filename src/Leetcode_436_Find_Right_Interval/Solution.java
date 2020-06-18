package Leetcode_436_Find_Right_Interval;

import java.util.Arrays;

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int len = intervals.length;
        int[] ans = new int[len];
        Arrays.fill(ans, -1);
        for(int i = 0; i < len; i++){
            int end = intervals[i][1];
            int diff = -1;
            int val = -1;
            for(int j = 0; j < len; j++){
                int start = intervals[j][0];
                if(start - end >= 0 && i != j){
                    if(diff == -1){
                        diff = start - end;
                        val = j;
                    }else{
                        if(diff > start - end){
                            diff = start - end;
                            val = j;
                        }
                    }
                }
            }
            ans[i] = val;
        }
        return ans;
    }
}
