package Leetcode_1652_Defuse_the_Bomb;

class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] ans = new int[code.length];
        for(int i = 0; i < code.length; i++){
            if(k == 0)
                ans[i] = 0;
            else
                ans[i] = helper(code, i, k);
        }
        return ans;
    }
    private int helper(int[] code, int i, int k){
        int len = code.length;
        int dir = 1;
        if(k < 0){
            dir = -1;
        }
        k = Math.abs(k);
        int sum = 0;
        if(dir > 0){
            i += 1;
            while(k > 0){
                sum += code[i % len];
                i++;
                k--;
            }
        }else{
            i -= 1;
            while(k > 0){
                if(i < 0)
                    i = len - 1;
                sum += code[i];
                i--;
                k--;
            }
        }
        return sum;
    }
}
