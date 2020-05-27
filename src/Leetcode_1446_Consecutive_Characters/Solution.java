package Leetcode_1446_Consecutive_Characters;

class Solution {
    public int maxPower(String s) {
        char[] arr = s.toCharArray();
        int l = 0;
        int r = 0;
        int max = 0;
        while(r < arr.length){
            if(arr[l] == arr[r]){
                max = Math.max(max, r - l + 1);
                r++;
            }else{
                l++;
            }
        }
        return max;
    }
}
