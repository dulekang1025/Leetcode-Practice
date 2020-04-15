package Leetcode_414_Third_Maximum_Number;

public class Solution3 {
    public int thirdMax(int[] nums) {
        long max = Long.MIN_VALUE;
        long second_max = Long.MIN_VALUE;
        long third_max = Long.MIN_VALUE;
        for(long i : nums){
            if(max < i){
                third_max = second_max;
                second_max = max;
                max = i;
            } else if(second_max < i && i != max){
                third_max = second_max;
                second_max = i;
            } else if( third_max < i && i != second_max && i != max){
                third_max = i;
            }
        }
        if(third_max != Long.MIN_VALUE) return (int)third_max;
        else return (int)max;
    }
    public static void main(String[] args){
        Solution3 s3 = new Solution3();
        int[] nums = new int[]{2,2,3,1};
        System.out.println(s3.thirdMax(nums));
    }
}
