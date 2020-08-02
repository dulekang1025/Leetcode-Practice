package Leetcode_1535_Find_the_Winner_of_an_Array_Game;

class Solution {
    public int getWinner(int[] arr, int k) {
        int len = arr.length;
        int greater = 0;
        if(k >= len - 1){
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < arr.length; i++)
                max = Math.max(max, arr[i]);
            return max;
        }else{
            int i = 0;
            int j = 1;
            int pre = 0;
            int temp = k;
            while(temp > 0 && i < len && j < len){
                int a = arr[i];
                int b = arr[j];
                if(temp == k){
                    pre = a > b ? a : b;
                    greater = pre;
                    temp--;
                }else{
                    greater = a > b ? a : b;
                    if(pre == greater){
                        temp--;
                    }else{
                        pre = greater;
                        temp = k - 1;
                    }
                }
                i = a > b ? i : (i > j ? i + 1 : j + 1);
                j = a > b ? (i > j ? i + 1 : j + 1) : j;
            }
        }
        return greater;
    }
}
