package Leetcode_1638_Count_Substrings_That_Differ_by_One_Character;

class Solution {
    public int countSubstrings(String s, String t) {
        int ans = 0;
        int lenS = s.length();
        int lenT = t.length();
        for(int i = 0; i < lenS; i++){
            for(int j = i + 1; j < lenS + 1; j++){
                String tempS = s.substring(i, j);
                for(int k = 0; k < lenT - tempS.length() + 1; k++){
                    String tempT = t.substring(k, k + tempS.length());
                    //System.out.println(tempS + " " + tempT);
                    if(check(tempS, tempT)){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    private boolean check(String a, String b){
        boolean f = true;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                if(!f) return false;
                else f = false;
            }
        }
        return !f;
    }
}
