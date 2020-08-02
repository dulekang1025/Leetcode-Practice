package Leetcode_1535_Find_the_Winner_of_an_Array_Game;

public class Solution2 {
    public int getWinner(int[] A, int k) {
        int cur = A[0];
        int win = 0;
        for(int i = 1; i < A.length; i++){
            if(A[i] > cur){
                cur = A[i];
                win = 0;
            }
            win++;
            if(win == k) return cur;
        }
        return cur;
    }
}
