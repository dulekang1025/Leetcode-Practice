package Leetcode_28_Implement_strStr;

class Solution {
    public int strStr(String haystack, String needle) {
        int ans = -1;
        int flag = 0;
        if(needle.length() == 0) return 0;
        for(int i = 0; i < (haystack.length() - needle.length()) + 1; i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                ans = i;
               for(int j = 0; j < needle.length(); j++){
                   if(haystack.charAt(j + i) != needle.charAt(j)){
                       flag = 0;
                       break;
                   }
                   else flag++;
               }
            }
            if(flag == needle.length()){
                break;
            }
            else ans = -1;
        }
        System.out.println(ans);
        return ans;
    }

    public static void main(String[] argv){
        Solution s = new Solution();
        s.strStr("a","a");
    }
}
