package Leetcode_844_Backspace_String_Compare;

class Solution {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1;
        int j = T.length() - 1;
        while(i >= 0 || j >= 0){
            i = helper(S, i);
            j = helper(T, j);
            if(i < 0 && j < 0) return true;
            if((i < 0 || j < 0) || S.charAt(i) != T.charAt(j)) return false;
            i--;
            j--;
        }
        return true;
    }
    private int helper(String s, int i){
        int skip = 0;
        while(i >= 0 && (skip > 0 || s.charAt(i) == '#')){
            if(s.charAt(i) == '#') skip++;
            else skip--;
            i--;
        }
        return i;
    }
}
