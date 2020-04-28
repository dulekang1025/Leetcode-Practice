package First_Unique_Number;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;


// This method did not pass all test cases, Time Limit Exceeded
class FirstUnique {

    // pair (insert index, occurance)
    private Queue<Map.Entry<Integer, Pair<Integer, Integer>>> pq = new PriorityQueue<>
            ((a, b) -> a.getValue().getValue() == b.getValue().getValue() ?
                    a.getValue().getKey() - b.getValue().getKey() :
                    a.getValue().getValue() - b.getValue().getValue());

    private Map<Integer, Pair<Integer, Integer>> map = new HashMap<>();

    public FirstUnique(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            this.map.put(nums[i], new Pair<>
                    (i, this.map.getOrDefault(nums[i], new Pair<>(i, 0)).getValue() + 1));
        }
        for(Map.Entry<Integer, Pair<Integer, Integer>> entry : map.entrySet()){
            pq.add(entry);
        }
    }

    public int showFirstUnique() {
        if(this.pq.peek().getValue().getValue() == 1) return this.pq.peek().getKey();
        else return -1;
    }

    public void add(int value) {
        int index = -1;
        int occurance = 0;
        if(map.containsKey(value)){
            Map.Entry<Integer, Pair<Integer, Integer>> entry = Map.entry(value, map.get(value));
            index = map.get(value).getKey();
            occurance = map.get(value).getValue();
            pq.remove(entry);
        }
        int key = index == -1 ? map.size() : index;
        int val = occurance == 0 ? 1 : occurance + 1;
        Pair<Integer, Integer> pair = new Pair<>(key, val);
        this.map.put(value, pair);
        pq.add(Map.entry(value, map.get(value)));
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
