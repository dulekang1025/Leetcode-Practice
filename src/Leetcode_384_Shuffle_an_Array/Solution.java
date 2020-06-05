package Leetcode_384_Shuffle_an_Array;

import java.util.Random;

class Solution {

    int[] a;
    int[] t;
    Random rand;

    public Solution(int[] nums) {
        a = nums.clone();
        t = nums;
        rand = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        a = t.clone();
        return a;
    }

    /** Returns a random shuffling of the array. */
    /** The Fisher-Yates algorithm. On each iteration of the algorithm,
     * we generate a random integer between the  current index and the last index of the array.
     * Then, we swap the elements at the current index and the chosen index - this simulates drawing
     * (and removing) the element from the hat, as the next range from which we select a random index will not
     * include the most recently processed one. One small, yet important detail is that it is possible to swap an
     * element with itself - otherwise, some array permutations would be more likely than others. */
    public int[] shuffle() {
        // https://zhuanlan.zhihu.com/p/33901269
        for(int i = 0; i < a.length; i++){
            int index = rand.nextInt(a.length - i) + i;
            int temp = a[i];
            a[i] = a[index];
            a[index] = temp;
        }
        return a;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
