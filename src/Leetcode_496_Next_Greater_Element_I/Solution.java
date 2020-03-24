package Leetcode_496_Next_Greater_Element_I;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            int next_greater_num = -1;
            int p = 0;
            while(p < nums2.length && nums2[p] != nums1[i]) p++;
            int cur = nums2[p];
            for(int j = p; j < nums2.length; j++){
                if(cur < nums2[j]) {
                    next_greater_num = nums2[j];
                    break;
                }
            }
            ans[i] = next_greater_num;
        }
        return ans;
    }
}
