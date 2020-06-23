package Leetcode_228_Summary_Ranges;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        Set<Long> set = new HashSet<>();
        for(int n : nums){
            set.add((long)n);
        }
        List<String> ans = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        for(long n : nums){
            if(set.contains(n - 1) && set.contains(n + 1)){
                continue;
            }else if(!set.contains(n - 1) && !set.contains(n + 1)){
                ans.add(n + "");
            }else if(!set.contains(n - 1) && set.contains(n + 1)){
                s.append(n);
                s.append("->");
            }else if(set.contains(n - 1) && !set.contains(n + 1)){
                s.append(n);
                ans.add(s.toString());
                s = new StringBuilder();
            }
        }
        return ans;
    }
}
