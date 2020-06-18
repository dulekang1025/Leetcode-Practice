package Leetcode_275_H_Index_II;

class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        if(len == 0 || citations[len - 1] == 0) return 0;
        int low = 0, high = citations.length, mid = 0;
        int res = 0;
        while(low < high){
            mid = low + (high - low) / 2;
            int num = len - mid;
            if(citations[mid] < num){
                low = mid + 1;
            }
            else high = mid;
        }
        return len - low;
    }
}