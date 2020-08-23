package Leetcode_1560_Most_Visited_Sector_in_a_Circular_Track;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> ans = new ArrayList<>();
        int f = rounds[0];
        int to = 1;
        int[] res = new int[n];
        while(to < rounds.length){
            int t = rounds[to];
            while(f != t){
                res[f - 1]++;
                f++;
                if(f > n) f = f % n;
            }
            to++;
        }
        res[f - 1]++;
        for(int a : res) System.out.print(a + " ");
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < res.length; i++){
            if(res[i] > max){
                ans.clear();
                max = res[i];
                ans.add(i + 1);
            }else if(res[i] == max){
                ans.add(i + 1);
            }
        }
        return ans;
    }
}
