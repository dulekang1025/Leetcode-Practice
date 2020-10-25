package Leetcode_1630_Arithmeticz_Subarrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int n = nums.length;
        int m = l.length;
        int[] arr = new int[n];
        List<Boolean> ans = new ArrayList<>();
        for(int i = 0 ; i < m; i++){
            int left = l[i];
            int right = r[i];
            if(check(nums, left, right)){
                ans.add(true);
            }else{
                ans.add(false);
            }
        }
        return ans;
    }

    private boolean check(int[] nums, int left, int right){
        List<Integer> list = new ArrayList<>();
        for(int i = left; i <= right; i++){
            list.add(nums[i]);
        }
        Collections.sort(list);
        Integer diff = null;
        for(int i = 1; i < list.size(); i++){
            if(diff == null){
                diff = list.get(i - 1) - list.get(i);
            }else{
                int temp = list.get(i - 1) - list.get(i);
                if(temp != diff){
                    return false;
                }
            }
        }
        return true;
    }
}
