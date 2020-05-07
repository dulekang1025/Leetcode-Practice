package Leetcode_71_Simplify_Path;

import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] temps = path.split("/");

        for(String s : temps){
            if(!s.equals("")){
                if(s.equals(".")){
                    continue;
                } else if(s.equals("..") && !stack.isEmpty()){
                    stack.pop();
                }else if(!s.equals(".") && !s.equals("..")){
                    stack.push(s);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < stack.size(); i++){
            sb.append("/" + stack.get(i));
        }
        String ans = sb.toString();
        return ans.length() == 0 ? "/" : ans;
    }
}
