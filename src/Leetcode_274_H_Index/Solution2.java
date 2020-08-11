package Leetcode_274_H_Index;

import java.util.Arrays;
import java.util.Collections;

public class Solution2 {
    public int hIndex(int[] citations) {
        int ans = 0;
        Integer[] a = new Integer[citations.length];
        for(int i = 0; i < citations.length; i++){
            a[i] = citations[i];
        }
        Arrays.sort(a, Collections.reverseOrder());
        for(int i = 0; i < citations.length; i++){
            if(a[i] >= i + 1){
                ans = i + 1;
            }else{
                break;
            }
        }
        return ans;
    }
}
