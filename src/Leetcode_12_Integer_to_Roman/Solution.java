package Leetcode_12_Integer_to_Roman;

class Solution {
    public String intToRoman(int num) {
        String ans = "";
        int[] numbers = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] str = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for(int i = 0; i < numbers.length; i++){
            while(num >= numbers[i]){
                ans += str[i];
                num -= numbers[i];
            }
        }
        return ans;
    }
}
