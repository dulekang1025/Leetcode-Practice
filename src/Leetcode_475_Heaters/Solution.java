package Leetcode_475_Heaters;

import java.util.Arrays;

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int r = 0;
        for(int i = 0; i < houses.length; i++){
            int low = 0;
            int high = heaters.length - 1;
            int mid = 0;
            while(low < high){
                mid = low + (high - low) / 2;
                if(heaters[mid] > houses[i]){
                    high = mid;
                }else{
                    low = mid + 1;
                }
            }
            //System.out.println(low);
            int rightPos = low;
            int leftPos = rightPos == 0 ? 0 : rightPos - 1;
            r = Math.max(r, Math.min(Math.abs(houses[i] - heaters[rightPos]), Math.abs(houses[i] - heaters[leftPos])));
        }
        return r;
    }
}
