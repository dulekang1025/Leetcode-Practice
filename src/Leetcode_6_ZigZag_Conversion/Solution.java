package Leetcode_6_ZigZag_Conversion;

class Solution {
    public String convert(String s, int numRows) {
        if(numRows <= 1) return s;
        String[] ans = new String[numRows];
        String res = "";
        int i = 0; int n = s.length();
        while(i < n){
            for(int j = 0; j < numRows && i < n; j++){
                if(ans[j] == null) ans[j] =  Character.toString(s.charAt(i++));
                else ans[j] += s.charAt(i++);
            }
            for(int k = numRows - 2; k >= 1 && i < n; k--){
                ans[k] += s.charAt(i++);
            }
        }
        for(String str : ans){
            if(str != null) res += str;
        }
        return res;
    }
}
