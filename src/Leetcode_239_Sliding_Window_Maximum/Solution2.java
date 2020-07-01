package Leetcode_239_Sliding_Window_Maximum;

import java.util.Deque;
import java.util.LinkedList;

class Solution2 {
    class Queue{
        Deque<Integer> deque = new
                LinkedList<>();
        public Queue(){
        }
        public void push(int num){
            while(!deque.isEmpty() && deque.peekLast() < num){
                deque.pollLast();
            }
            deque.offerLast(num);
        }
        public void pop(){
            deque.pollFirst();
        }
        public int max(){
            return deque.peekFirst();
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] ans = new int[len - k + 1];
        int left = 0;
        int right = 0;
        Queue queue = new Queue();
        int i = 0;
        while(right < len){
            while(right - left < k){
                queue.push(nums[right]);
                right++;
            }
            ans[i++] = queue.max();
            if(right - left == k){
                if(queue.max() == nums[left]){
                    queue.pop();
                }
                left++;
            }
        }
        return ans;
    }
}
