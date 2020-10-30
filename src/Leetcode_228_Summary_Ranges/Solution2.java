package Leetcode_228_Summary_Ranges;

import java.util.ArrayList;
import java.util.List;

class Solution2 {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int i = 0;
        while(i < nums.length){
            int j = i;
            while(j < nums.length - 1 && nums[j] + 1 == nums[j + 1]){
                j++;
            }
            String s = null;
            if(i != j) s = nums[i] + "->" + nums[j];
            else s = nums[i] + "";
            ans.add(s);
            i = j + 1;
        }
        return ans;
    }
}
