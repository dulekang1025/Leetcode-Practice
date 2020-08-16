package Leetcode_1550_Three_Consecutive_Odds;

class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int left = 0, right = 0;
        int count = 0;
        while(right < arr.length){
            if(arr[right] % 2 == 1){
                count++;
            }else{
                left = right;
                count = 0;
            }
            if(count == 3) return true;
            right++;
        }
        return false;
    }
}
