package Leetcode_346_Moving_Average_from_Data_Stream;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    Queue<Integer> queue;
    int sum;
    int size;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.queue = new LinkedList<>();
        this.sum = 0;
        this.size = size;
    }

    public double next(int val) {
        double res = 0;
        if(queue.size() >= this.size){
            sum -= queue.poll();
        }
        queue.offer(val);
        sum += val;
        res = sum * 1.0 / queue.size();
        return res;
    }
}
