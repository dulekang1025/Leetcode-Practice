package Leetcode_17_Letter_Combinations_of_a_Phone_Number;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0 || digits == null) return ans;
        String[] d = new String[]{" ", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        char[] c = new char[digits.length()];
        dfs(ans, digits, d, c, 0);
        return ans;
    }
    private void dfs(List<String> ans, String digits, String[] d, char[] c, int len){
        if(len == digits.length()){
            ans.add(new String(c));
            return;
        }
        String cur = d[digits.charAt(len) - '0'];
        for(int i = 0; i < cur.length(); i++){
            c[len] = cur.charAt(i);
            dfs(ans, digits, d, c, len + 1);
        }
    }
}
