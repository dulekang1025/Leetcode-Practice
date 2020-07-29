package Leetcode_1375_Bulb_Switcher_III;

class Solution {
    public int numTimesAllBlue(int[] light) {
        int max = 0;
        int ans = 0;
        for(int i = 0; i < light.length; i++){
            max = Math.max(max, light[i]);
            if(max == i + 1) ans++;
        }
        return ans;
    }
}
