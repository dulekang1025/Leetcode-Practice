package Leetcode_1642_Furthest_Building_You_Can_Reach;

class Solution {
    int max = 0;
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        helper(heights, bricks, ladders, 0);
        return max;
    }
    private void helper(int[] h, int b, int l, int i){
        if(max == h.length - 1) return;
        if(i == h.length - 1 || (h[i + 1] - h[i] > b && l == 0)){
            max = Math.max(max, i);
            return;
        }
        if(h[i] > h[i + 1]){
            helper(h, b, l, i + 1);
        }else{
            if(l > 0){
                helper(h, b, l - 1, i + 1);
            }
            if(h[i + 1] - h[i] <= b){
                helper(h, b - (h[i + 1] - h[i]), l, i + 1);
            }
        }
    }
}
