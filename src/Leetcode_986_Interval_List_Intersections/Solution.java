package Leetcode_986_Interval_List_Intersections;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int []> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < A.length && j < B.length){
            int start = Math.max(A[i][0], B[j][0]);
            int end = Math.min(A[i][1], B[j][1]);
            if(start <= end){
                ans.add(new int[]{start, end});
            }
            if(A[i][1] > B[j][1]){
                j++;
            }else{
                i++;
            }
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}
