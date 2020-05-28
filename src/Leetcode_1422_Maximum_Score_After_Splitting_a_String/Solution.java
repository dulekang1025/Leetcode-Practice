package Leetcode_1422_Maximum_Score_After_Splitting_a_String;

class Solution {
    public int maxScore(String s) {
        int right = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1')
                right++;
        }
        int left = 0;
        for(int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) == '0'){
                left++;
            }else{
                right--;
            }
            max = Math.max(max, left + right);
        }
        return max;
    }
}
