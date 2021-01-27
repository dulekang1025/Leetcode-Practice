package Leetcode_532_K_diff_Pairs_in_an_Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    public int findPairs(int[] nums, int k) {
        Set<String> set = new HashSet<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++){
            int j = i + 1;
            while(j < nums.length){
                int diff = Math.abs(nums[i] - nums[j]);
                if(diff == k){
                    StringBuilder sb = new StringBuilder();
                    sb.append(nums[i]);
                    sb.append(',');
                    sb.append(nums[j]);
                    set.add(sb.toString());
                    j++;
                }else if(diff < k){
                    j++;
                }else{
                    break;
                }
            }
        }
        return set.size();
    }
}
