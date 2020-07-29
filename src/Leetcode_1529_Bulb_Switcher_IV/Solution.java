package Leetcode_1529_Bulb_Switcher_IV;

class Solution {
    public int minFlips(String target) {
        int cur = 0;
        int res = 0;
        for(int i = 0; i < target.length(); i++){
            if(target.charAt(i) != cur + '0'){
                res++;
                cur = cur == 1 ? 0 : 1;
            }
        }
        return res;
    }
}
