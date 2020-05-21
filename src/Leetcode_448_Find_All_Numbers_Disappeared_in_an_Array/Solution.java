package Leetcode_448_Find_All_Numbers_Disappeared_in_an_Array;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            nums[Math.abs(nums[i]) - 1] *= nums[Math.abs(nums[i]) - 1] > 0 ? -1 : 1;
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0)
                ans.add(i + 1);
        }
        return ans;
    }
}
