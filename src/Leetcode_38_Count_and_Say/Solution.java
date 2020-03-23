package Leetcode_38_Count_and_Say;

class Solution {
    public String countAndSay(int n) {
        String res = "1";
        while(n > 1){
            int count = 1;
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < res.length(); i++){
                count = 1;
                while(i < res.length() - 1 && res.charAt(i) == res.charAt(i+1)){
                    count++;
                    i++;
                }
                sb.append(String.valueOf(count));
                sb.append(res.charAt(i));
            }
            res = sb.toString();
            n--;
        }
        return res;
    }
}
