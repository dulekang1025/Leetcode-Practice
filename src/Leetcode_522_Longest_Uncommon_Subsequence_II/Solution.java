package Leetcode_522_Longest_Uncommon_Subsequence_II;

class Solution {
    public int findLUSlength(String[] strs) {
        int res = -1;
        for(int i = 0; i < strs.length; i++){
            int j = 0;
            for(; j < strs.length; j++){
                if(i == j) continue;
                if(isSub(strs[i], strs[j])) break;
            }
            if(j == strs.length)
                res = Math.max(strs[i].length(), res);
        }
        return res;
    }
    private boolean isSub(String sub, String target){
        int i = 0;
        for(char c : target.toCharArray()){
            if(c == sub.charAt(i)){
                i++;
            }
            if(i == sub.length())
                break;
        }
        return i == sub.length();
    }
}
