package Leetcode_784_Letter_Case_Permutation;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    List<String> ans = new ArrayList<>();
    public List<String> letterCasePermutation(String S) {
        dfs(new StringBuilder(S), 0);
        return ans;
    }
    private void dfs(StringBuilder s, int index){
        if(index == s.length()){
            ans.add(s.toString());
            return;
        }
        char c = s.charAt(index);
        if(Character.isLetter(c)){
            dfs(s, index + 1);
            c = Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c);
            s.setCharAt(index, c);
            dfs(s, index + 1);
        }else{
            dfs(s, index + 1);
        }
    }
}
