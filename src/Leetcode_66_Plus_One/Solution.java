package Leetcode_66_Plus_One;

class Solution {
    public int[] plusOne(int[] digits) {
        int flag = 0;
        int carry = 0;
        for(int i = digits.length - 1; i >= 0 ; i--){
            if(flag == 0){
                flag = 1;
                if(digits[i] >= 9){
                    digits[i] = 0;
                    carry = 1;
                }else{
                    digits[i] += 1;
                    return digits;
                }
            }else{
                if(digits[i] >= 9){
                    digits[i] = 0;
                }else{
                    digits[i] += 1;
                    carry = 0;
                    return digits;
                }
            }
        }
        if(carry == 1){
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }
        return null;
    }
}
