package Leetcode_278_First_Bad_Version;

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        int mid = 0;
        while(low < high){
            mid = low + (high - low) / 2;
            if(isBadVersion(mid)){
                high = mid;   // mid - 1 ???
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}

class VersionControl{
    public boolean isBadVersion(int n){
        return true;
    }
}