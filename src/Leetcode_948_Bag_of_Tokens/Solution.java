package Leetcode_948_Bag_of_Tokens;

import java.util.Arrays;

class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int left = 0, right = tokens.length - 1;
        int res = 0, temp = 0;
        while(left <= right){
            if(tokens[left] <= P){
                P -= tokens[left];
                temp += 1;
                left++;
                res = Math.max(res, temp);
            }else if(temp == 0){
                break;
            }else{
                P += tokens[right];
                right--;
                temp -= 1;
            }
        }
        return res;
    }
}
