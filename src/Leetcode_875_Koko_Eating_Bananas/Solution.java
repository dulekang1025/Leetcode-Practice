package Leetcode_875_Koko_Eating_Bananas;

class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        // first, find out k's range
        int low = 1;
        int high = 0;
        int mid = 0;
        for(int n : piles) high = high > n ? high : n;
        // second, search the lowest k that makes the spending time shortest.
        while(low < high){
            mid = low + (high - low) / 2;
            int time = 0;
            for(int n : piles) time += Math.ceil((double)n / (double)mid);
            if(time > H) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}
