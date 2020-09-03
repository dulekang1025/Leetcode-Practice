package Leetcode_459_Repeated_Substring_Pattern;

public class Solution2 {
    public boolean repeatedSubstringPattern(String s) {
        for(int i = s.length() / 2; i > 0; i--){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < s.length() / i; j++){
                sb.append(s.substring(0,i));
            }
            if(sb.toString().equals(s)) return true;
        }
        return false;
    }
}
