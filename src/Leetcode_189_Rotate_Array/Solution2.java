package Leetcode_189_Rotate_Array;

class Solution2 {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        if(k == len) return;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
        return;
    }
    private void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
        return;
    }
}
