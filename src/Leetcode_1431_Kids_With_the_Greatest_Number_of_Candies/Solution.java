package Leetcode_1431_Kids_With_the_Greatest_Number_of_Candies;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for(int n : candies){
            max = Math.max(max, n);
        }
        List<Boolean> ans = new ArrayList<>();
        for(int i = 0; i < candies.length; i++){
            if(candies[i] + extraCandies >= max)
                ans.add(true);
            else
                ans.add(false);
        }
        return ans;
    }
}
