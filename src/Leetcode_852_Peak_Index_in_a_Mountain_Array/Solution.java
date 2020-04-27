package Leetcode_852_Peak_Index_in_a_Mountain_Array;

class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int low = 0;
        int high = A.length - 1;
        int mid = 0;
        while(low < high){
            mid = (low + high) / 2;
            if(A[mid] > A[mid + 1]) high = mid;
            else low = mid + 1;
        }
        return low;
    }
}
