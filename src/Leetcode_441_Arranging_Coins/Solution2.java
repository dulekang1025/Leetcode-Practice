package Leetcode_441_Arranging_Coins;

class Solution2 {
    public int arrangeCoins(int n) {
        //再来看一种O(lgn)的方法，用到了二分搜索法，我们搜索前i行之和刚好大于n的临界点，
        //这样我们减一个就是能排满的行数，注意我们计算前i行之和有可能会整型溢出，所以我们需要将变量都定义成长整型
        if(n <= 1) return n;
        long low = 1;
        long high = n;
        while(low < high){
            long mid = low + (high - low) / 2;
            long sum = mid * (mid + 1) / 2;
            if(sum > n) high = mid;
            else low = mid + 1;
        }
        return (int)low - 1;
    }
}
