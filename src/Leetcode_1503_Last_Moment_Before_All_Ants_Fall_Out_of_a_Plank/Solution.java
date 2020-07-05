package Leetcode_1503_Last_Moment_Before_All_Ants_Fall_Out_of_a_Plank;

import java.util.Arrays;

class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        Arrays.sort(left);
        Arrays.sort(right);
        int res = 0;
        if(left.length != 0) res = Math.max(left[left.length - 1], res);
        if(right.length != 0) res = Math.max(n - right[0], res);
        return res;
    }
}
