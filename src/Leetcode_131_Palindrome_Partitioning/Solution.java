package Leetcode_131_Palindrome_Partitioning;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<String>> ans = new ArrayList<>();
    List<String> cur = new ArrayList<>();
    String s;
    public List<List<String>> partition(String s) {
        this.s = s;
        dfs(0);
        return ans;
    }
    private void dfs(int index){
        if(index == s.length()){
            ans.add(new ArrayList<>(cur));
            return;
        }
        for(int i = index + 1; i <= s.length(); i++){
            String sub = s.substring(index, i);
            //System.out.println(sub);
            if(vaild(sub)){
                cur.add(sub);
                dfs(i);
                cur.remove(cur.size() - 1);
            }
        }
    }
    private boolean vaild(String s){
        int head = 0;
        int tail = s.length() - 1;
        while(head < tail){
            if(s.charAt(head) != s.charAt(tail)) return false;
            head++;
            tail--;
        }
        return true;
    }
}
