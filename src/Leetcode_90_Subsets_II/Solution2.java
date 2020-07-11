package Leetcode_90_Subsets_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution2 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0);
        return ans;
    }
    private void dfs(int[] nums, int index){
        ans.add(new ArrayList<>(list));
        for(int i = index; i < nums.length; i++){
            if(i > index && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            dfs(nums, i + 1);
            list.remove(list.size() - 1);
            //while(i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
        }
    }
}