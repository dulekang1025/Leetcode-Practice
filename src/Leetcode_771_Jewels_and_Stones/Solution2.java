package Leetcode_771_Jewels_and_Stones;

import java.util.HashSet;
import java.util.Set;

class Solution2 {
    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        int ans = 0;
        for(int i = 0; i < J.length(); i++){
            set.add(J.charAt(i));
        }
        for(int j = 0; j < S.length(); j++){
            if(set.contains(S.charAt(j))) ans++;
        }
        return ans;
    }
}
