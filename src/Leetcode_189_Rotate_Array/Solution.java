package Leetcode_189_Rotate_Array;

class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        int cur = 0;
        int count = 0;
        for(int start = 0; count < nums.length; start++){
            cur = start;
            int prev = nums[cur];
            do{
                int next = (cur + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                cur = next;
                count++;
            }while(cur != start);
        }
    }
}
