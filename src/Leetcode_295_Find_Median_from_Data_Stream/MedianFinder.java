package Leetcode_295_Find_Median_from_Data_Stream;

import java.util.PriorityQueue;
import java.util.Queue;

class MedianFinder {

    private Queue<Integer> maxHeap;
    private Queue<Integer> minHeap;


    /** initialize your data structure here. */
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>((a, b) -> a - b);
    }

    public void addNum(int num) {
        if(maxHeap.isEmpty() || num < maxHeap.peek()){
            maxHeap.add(num);
        }else{
            minHeap.add(num);
        }
        if(maxHeap.size() - minHeap.size() > 1){
            minHeap.add(maxHeap.poll());
        }
        if(maxHeap.size() < minHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        double ans = 0.0;
        if(maxHeap.size() > minHeap.size()){
            ans = (double)maxHeap.peek();
        }else{
            ans = ((double)maxHeap.peek() + (double)minHeap.peek()) / 2;
        }
        return ans;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
