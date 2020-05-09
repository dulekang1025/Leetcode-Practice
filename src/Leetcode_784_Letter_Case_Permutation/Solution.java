package Leetcode_784_Letter_Case_Permutation;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> letterCasePermutation(String S) {
        dfs(new StringBuilder(S), 0);
        return ans;
    }
    private void dfs(StringBuilder sb, int pos){
        if(pos == sb.length()){
            ans.add(sb.toString());
            return;
        }
        char cur = sb.charAt(pos);
        if((cur <= 90 && cur >= 65) ||(cur >= 97 && cur <= 122)){
            dfs(sb, pos + 1);
            sb.setCharAt(pos, (char)(cur ^ 32));
            dfs(sb, pos + 1);
        }else{
            dfs(sb, pos + 1);
        }
    }
}
