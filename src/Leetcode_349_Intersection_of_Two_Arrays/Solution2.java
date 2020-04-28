package Leetcode_349_Intersection_of_Two_Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> l = new HashSet<>();
        int m = nums1.length;
        int n = nums2.length;
        int[] longArray = m >= n ? nums1 : nums2;
        int[] shortArray = m >= n ? nums2 : nums1;
        Arrays.sort(longArray);
        for(int i = 0; i < shortArray.length; i++){
            int low = 0;
            int high = longArray.length - 1;
            int mid = 0;
            while(low <= high){
                mid = low + (high - low) / 2;
                if(longArray[mid] == shortArray[i]){
                    l.add(shortArray[i]);
                    break;
                }else if(longArray[mid] > shortArray[i]){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
        }
        int[] res = new int[l.size()];
        int i = 0;
        for(int k : l){
            res[i++] = k;
        }
        return res;
    }
}
