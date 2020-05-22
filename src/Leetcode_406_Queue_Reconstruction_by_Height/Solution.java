package Leetcode_406_Queue_Reconstruction_by_Height;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> ans = new ArrayList<>();
        for(int[] p : people){
            ans.add(p[1], p);
        }
        // important
        return ans.toArray(new int[ans.size()][2]);
    }
}
