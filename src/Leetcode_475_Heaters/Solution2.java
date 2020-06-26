package Leetcode_475_Heaters;

import java.util.Arrays;

class Solution2 {
    public int findRadius(int[] houses, int[] heaters) {
        int r = 0;
        Arrays.sort(heaters);
        // no duplicate
        // find lower bound
        for(int i = 0; i < houses.length; i++){
            int low = 0;
            int high = heaters.length;
            while(low < high){
                int mid = low + (high - low) / 2;
                if(heaters[mid] >= houses[i]){
                    high = mid;
                }else{
                    low = mid + 1;
                }
            }
            int right = low == heaters.length ? low - 1 : low;
            int left = right == 0 ? 0 : right - 1;
            r = Math.max(r, Math.min(Math.abs(houses[i] - heaters[right]), Math.abs(houses[i] - heaters[left])));
        }
        return r;
    }
}
