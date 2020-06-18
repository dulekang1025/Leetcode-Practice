package Leetcode_436_Find_Right_Interval;

import java.util.Arrays;

public class Solution2 {
    public int[] findRightInterval(int[][] intervals) {
        int len = intervals.length;
        int[][] bs = new int[intervals.length][2];
        for(int i = 0; i < len; i++){
            bs[i][0] = intervals[i][0];
            bs[i][1] = i;
        }
        Arrays.sort(bs, (a, b) -> a[0] - b[0]);
        int[] ans = new int[len];
        Arrays.fill(ans, -1);
        for(int i = 0; i < len; i++){
            int val = intervals[i][1];
            int low = 0, high = len, mid = 0;
            while(low < high){
                mid = low + (high - low) / 2;
                if(bs[mid][0] < val)
                    low = mid + 1;
                else
                    high = mid;
            }
            ans[i] = low == len ? -1 : bs[low][1];
        }
        return ans;
    }
}
