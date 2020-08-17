package Leetcode_1103_Distribute_Candies_to_People;

class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] out = new int[num_people];
        int i = 0;
        int loop = 0;
        while(candies > 0){
            if(i == num_people){
                i = 0;
                loop += 1;
            }
            int cur = (loop * num_people) + (i + 1);
            if(candies - cur > 0){
                out[i] += cur;
            }else{
                out[i] += candies;
            }
            i++;
            candies -= cur;
        }
        return out;
    }
}
