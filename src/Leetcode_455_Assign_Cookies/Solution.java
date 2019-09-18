package Leetcode_455_Assign_Cookies;

import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        int i = 0;  // j for cookies, i for children
        for(int j=0; i<g.length && j<s.length;j++){
            //If sj >= gi, we can assign the cookie j to the child i
            if(s[j] >= g[i]){
                i++;
                res++;
            }
        }
        return res;
    }
}
