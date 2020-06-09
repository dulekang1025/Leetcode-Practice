package Leetcode_705_Design_HashSet;

import java.util.LinkedList;

class MyHashSet3 {

    Bucket[] arr;
    int hashBase = 769;

    /** Initialize your data structure here. */
    public MyHashSet3() {
        arr = new Bucket[hashBase];
        for(int i = 0; i < hashBase; i++){
            arr[i] = new Bucket();
        }
    }

    protected int getHash(int key){
        return key % hashBase;
    }

    public void add(int key) {
        int code = getHash(key);
        arr[code].insert(key);
    }

    public void remove(int key) {
        int code = getHash(key);
        arr[code].delete(key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int code = getHash(key);
        return arr[code].contains(key);
    }

    class Bucket{
        LinkedList<Integer> bucket;
        public Bucket(){
            bucket = new LinkedList<>();
        }

        public void insert(Integer key){
            if(bucket.indexOf(key) == -1){
                bucket.addFirst(key);
            }
        }

        public void delete(Integer key){
            if(bucket.indexOf(key) != -1){
                bucket.remove(key);
            }
        }

        public boolean contains(Integer key){
            return bucket.indexOf(key) != -1;
        }
    }
}
