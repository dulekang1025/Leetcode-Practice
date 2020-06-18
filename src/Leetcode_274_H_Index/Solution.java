package Leetcode_274_H_Index;

import java.util.Arrays;

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;
        if(len == 0 || citations[len - 1] == 0) return 0;
        int low = 0, high = len, mid = 0;
        while(low < high){
            mid = low + (high - low) / 2;
            if(citations[mid] >= len - mid){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return len - low;
    }
}
