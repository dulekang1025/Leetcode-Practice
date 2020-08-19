package Leetcode_28_Implement_strStr;

public class Solution2 {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        for(int i = 0; i < haystack.length() - needle.length() + 1; i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                if(check(haystack.substring(i, i + needle.length()), needle)){
                    return i;
                }
            }
        }
        return -1;
    }
    private boolean check(String t1, String t2){
        return t1.equals(t2);
    }
}
