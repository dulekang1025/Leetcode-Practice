package Leetcode_1023_Camelcase_Matching;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        // TODO : trie tree
        List<Boolean> ans = new ArrayList<>();
        for(String q : queries){
            int i = 0, j = 0;
            StringBuilder sb = new StringBuilder();
            while(i < q.length() && j < pattern.length()){
                if(q.charAt(i) == pattern.charAt(j)){
                    i++;
                    j++;
                }else{
                    sb.append(q.charAt(i));
                    i++;
                }
            }
            if(j != pattern.length()){
                ans.add(false);
                continue;
            }
            while(i < q.length()){
                sb.append(q.charAt(i));
                i++;
            }
            boolean f = true;
            for(char c : sb.toString().toCharArray()){
                if(!Character.isLowerCase(c)){
                    ans.add(false);
                    f = false;
                    break;
                }
            }
            if(f) ans.add(true);
        }
        return ans;
    }
}
