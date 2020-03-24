package Leetcode_739_Daily_Temperatures;

class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        for(int i = 0; i < T.length; i++){
            boolean flag = false;
            int count = 0;
            for(int j = i + 1; j < T.length; j++){
                if(T[j] > T[i]) {
                    flag = true;
                    count++;
                    break;
                }
                count++;
            }
            if(flag) ans[i] = count;
            else ans[i] = 0;
        }
        return ans;
    }
}
