package Leetcode_169_Majority_Element;

// moore voting
class Solution2 {
    public int majorityElement(int[] nums) {
        int m = 0;
        int n = 0;
        for(int i = 0; i < nums.length; i++){
            if(n == 0){
                m = nums[i];
                n++;
            }
            else{
                if(m == nums[i]) n++;
                else n--;
            }
        }
        return m;
    }
}
