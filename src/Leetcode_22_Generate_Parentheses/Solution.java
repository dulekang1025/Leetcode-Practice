package Leetcode_22_Generate_Parentheses;


import java.util.ArrayList;
import java.util.List;

// 1, 对于这种列出所有结果的题首先还是考虑用递归Recursion来解
// 2,
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, n,n,"");
        return res;
    }
    public void helper(List<String> res, int left, int right, String s){
        if(left > right) return;
        if(left == 0 && right == 0){
            res.add(s);
            return;
        }
        if(left > 0){
            helper(res,left - 1,right, s + "(");
        }
        if(right > 0){
            helper(res,left,right - 1, s + ")");
        }
    }
}
