package Leetcode_12_Integer_to_Roman;

public class Solution2 {
    public String intToRoman(int num) {
        int[] nums = new int[]   { 1,  4,   5,  9,  10, 40,  50,  90, 100, 400,500,900,1000};
        String[] s = new String[]{"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        StringBuilder sb = new StringBuilder();
        while(num > 0){
            for(int i = nums.length - 1; i >= 0; i--){
                if(num >= nums[i]){
                    sb.append(s[i]);
                    num -= nums[i];
                    break;
                }
            }
        }
        return sb.toString();
    }
}
