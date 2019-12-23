package Leetcode_14_Longest_Common_Prefix;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        String res = strs[0];
        for(String s : strs){
            String temp = "";
            int size = (res.length() > s.length()) ? s.length() : res.length();
            for(int i = 0; i < size; i++){
                if(!res.substring(0, i + 1).equals(s.substring(0, i + 1))){
                    if(temp.length() > 0) {
                        res = temp;
                        break;
                    }
                    else return "";
                }
                if(res.charAt(i) == s.charAt(i)){
                    temp += s.charAt(i);
                }
            }
            res = temp;
        }
        return res;
    }
}


