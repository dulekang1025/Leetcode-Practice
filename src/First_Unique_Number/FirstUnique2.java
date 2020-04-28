package First_Unique_Number;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


// This code passed all test cases.
class FirstUnique2 {

    private Queue<Integer> queue = new LinkedList<>();
    private Map<Integer, Integer> map = new HashMap<>();

    public FirstUnique2(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            queue.offer(nums[i]);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
    }

    public int showFirstUnique() {
        while(queue.size() != 0){
            int first = queue.peek();
            //System.out.println(first);
            if(map.getOrDefault(first, 0) == 1) return first;
            else queue.poll();
        }
        return -1;
    }

    public void add(int value) {
        if(!map.containsKey(value)) queue.offer(value);
        map.put(value, map.getOrDefault(value, 0) + 1);

    }
}
