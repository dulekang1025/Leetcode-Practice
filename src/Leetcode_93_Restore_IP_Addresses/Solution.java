package Leetcode_93_Restore_IP_Addresses;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private StringBuilder sb = new StringBuilder();
    private List<String> res = new ArrayList<>();
    private String s;
    public List<String> restoreIpAddresses(String s) {
        if(s == null || s.length() > 12 || s.length() < 4) return this.res;
        this.s = s;
        dfs(0, 0);
        return this.res;
    }
    private void dfs(int part, int index){
        if(part == 4 && index == s.length()){
            res.add(sb.toString());
        }
        for(int i = 1; i <= 3; i++){
            if(index + i > s.length()) break;
            String val = s.substring(index, index + i);
            // begain with '0'
            if(i > 1 && s.charAt(index) == '0') break;
            // greater than 255
            if(i == 3 && Integer.valueOf(val) > 255) break;
            int startPos = sb.length();
            if(part == 0){
                sb.append(val);
            }else{
                sb.append(".");
                sb.append(val);
            }
            dfs(part + 1, index + i);
            sb.delete(startPos, startPos + i + 1);
        }
    }
}
