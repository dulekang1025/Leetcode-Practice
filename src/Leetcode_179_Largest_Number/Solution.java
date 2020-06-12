package Leetcode_179_Largest_Number;

import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        String[] arr = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        for(String s : arr){
            sb.append(s);
        }
        if(sb.charAt(0) == '0') return "0";
        return sb.toString();
    }
}
