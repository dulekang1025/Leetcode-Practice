package Leetcode_933_Number_of_Recent_Calls;

import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {

    Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        while(!queue.isEmpty() && t - queue.peek() > 3000){
            queue.poll();
        }
        queue.offer(t);
        return queue.size();
    }

}

