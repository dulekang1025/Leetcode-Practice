package Leetcode_705_Design_HashSet;

class MyHashSet {

    int arr[];

    /** Initialize your data structure here. */
    public MyHashSet() {
        arr = new int[1000000];
    }

    public void add(int key) {
        this.arr[key] = 1;
    }

    public void remove(int key) {
        this.arr[key] = 0;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return this.arr[key] == 1;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
