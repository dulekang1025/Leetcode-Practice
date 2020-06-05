package Leetcode_398_Random_Pick_Index;

import java.util.Random;

class Solution2 {

    Random rand = new Random();
    int[] a;

    public Solution2(int[] nums) {
        a = nums;
    }

    public int pick(int target) {
        //假设当前正要读取第n个数据，
        //则我们以1/n的概率留下该数据，否则留下前n-1个数据中的一个。
        int count = 0;
        int res = 0;
        for(int i = 0; i < a.length; i++){
            if(target == a[i]){
                count++;
                if(rand.nextInt(count) == 0)
                    res = i;
            }
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
