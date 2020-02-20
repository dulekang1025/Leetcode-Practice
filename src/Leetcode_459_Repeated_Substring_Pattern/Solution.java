package Leetcode_459_Repeated_Substring_Pattern;

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        for(int i = 1; i <= s.length() / 2; i++){
            if(s.length() % i == 0){
                String t = "";
                for(int j = 0; j < s.length() / i; j++){
                    t += s.substring(0,i);
                }
                System.out.println(t);
                if(s.equals(t)) return true;
            }
        }
        return false;
    }
}
