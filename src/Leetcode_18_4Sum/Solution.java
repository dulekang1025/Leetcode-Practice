package Leetcode_18_4Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i + 1; j < nums.length - 2; j++){
                if(j > i + 1 && nums[j] == nums[j-1]) continue; // j > i + 1
                int low = j + 1;
                int high = nums.length - 1;
                while(low < high){
                    if((nums[i] + nums[j] + nums[low] + nums[high]) == target){
                        res.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        while(low < high && nums[low] == nums[low+1]) low++;
                        while(low < high && nums[high] == nums[high - 1]) high--;
                        low++;
                        high--;
                    }else if((nums[i] + nums[j] + nums[low] + nums[high]) > target){
                        high--;
                    }else{
                        low++;
                    }
                }
            }
        }
        return res;
    }
}
