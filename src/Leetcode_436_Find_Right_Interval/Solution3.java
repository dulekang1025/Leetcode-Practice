package Leetcode_436_Find_Right_Interval;

import java.util.Arrays;
import java.util.TreeSet;

class Solution3 {
    public int[] findRightInterval(int[][] intervals) {
        int len = intervals.length;
        TreeSet<int[]> set = new TreeSet<>((a, b) -> a[0] - b[0]);
        for(int i = 0; i < len; i++){
            int[] bs = new int[2];
            bs[0] = intervals[i][0];
            bs[1] = i;
            set.add(bs);
        }
        int[] ans = new int[len];
        Arrays.fill(ans, -1);

        for(int i = 0; i < len; i++){
            int val = intervals[i][1];
            int[] p = set.ceiling(new int[]{val, i});
            if(p != null){
                ans[i] = p[1];
            }
        }
        return ans;
    }
}
