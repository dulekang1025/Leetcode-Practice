package Leetcode_75_Sort_Colors;

class Solution2 {
    public void sortColors(int[] nums) {
        if(nums.length == 0 || nums.length == 1) return;
        int p1 = 0, p2 = nums.length - 1;
        boolean hasZero = false;
        while(p2 >= 0 && nums[p2] == 2){
            p2--;
        }
        while(p1 < nums.length && nums[p1] == 0){
            p1++;
        }
        while(p1 <= p2){
            if(nums[p1] == 0 || nums[p2] == 0) hasZero = true;
            if(nums[p1] == 2){
                int temp = nums[p2];
                nums[p2] = nums[p1];
                nums[p1] = temp;
                p2--;
            }
            p1++;
            while(p1 <= p2 && nums[p2] == 2){
                p2--;
            }

        }
        if(!hasZero) return;
        p1 = 0;
        while(p2 >= 0 && nums[p2] == 1){
            p2--;
        }
        while(p1 < p2){
            if(nums[p1] == 1){
                int temp = nums[p2];
                nums[p2] = nums[p1];
                nums[p1] = temp;
                p2--;
            }
            p1++;
            while(p1 <= p2 && nums[p2] == 1){
                p2--;
            }
        }
    }
}

