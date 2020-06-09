package Leetcode_705_Design_HashSet;

class MyHashSet2 {

    boolean arr[];

    /** Initialize your data structure here. */
    public MyHashSet2() {
        arr = new boolean[1000001];
    }

    public void add(int key) {
        this.arr[key] = true;
    }

    public void remove(int key) {
        this.arr[key] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return this.arr[key] == true;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
