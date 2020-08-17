package Leetcode_8_String_to_Integer;

public class Solution2 {
    public int myAtoi(String str) {
        int ans = 0;
        str = str.trim();
        if(str.length() == 0) return ans;
        int sign = 1;
        int i = 0;
        if(str.charAt(i) == '+'){
            i++;
        }else if(str.charAt(i) == '-'){
            sign = -1;
            i++;
        }
        for(; i < str.length(); i++){
            int n = str.charAt(i) - '0';
            if(n < 0 || n > 9) break;
            if(ans > (Integer.MAX_VALUE - n) / 10){
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + n;
        }
        ans *= sign;
        return ans;
    }
}
