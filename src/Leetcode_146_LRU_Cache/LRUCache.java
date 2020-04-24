package Leetcode_146_LRU_Cache;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    class Node{
        public Node prev;
        public Node next;
        public int val;
        public int key;
        public Node(int key, int val){
            this.val = val;
            this.key = key;
        }
    }

    Map<Integer, Node> map = new HashMap<>();
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    private int cap;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        int res = -1;
        Node node = map.get(key);
        System.out.println("In put method, get " + key + " " + node);
        if(node != null){
            remove(node);
            add(node);
            res = node.val;
        }
//        System.out.println("get " + key + " : " + res);
        printList();
        return res;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if(node != null){
            remove(node);
            node.val = value;
            add(node);
        }else{
            node = new Node(key, value);
            if(map.size() == cap){
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
            add(node);
            map.put(key, node);
        }
//        System.out.println("put " + key + " : " + value);
        printList();

    }

    public void add(Node node){
        // add after the head;
        Node head_next = head.next;
        node.next = head.next;
        head_next.prev = node;
        head.next = node;
        node.prev = head;
//        System.out.println("add " + node.key + " : " + node.val);
    }

    public void printList(){
        Node p = head.next;
        for(int i = map.size(); i > 0; i--){
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }

    public void remove(Node node){
        // remove node
        Node prev_node = node.prev;
        Node next_node = node.next;
        next_node.prev = prev_node;
        prev_node.next = next_node;
//        System.out.println("remove " + node.key + " : " + node.val);

    }


    public static void main(String[] args){
        LRUCache l = new LRUCache(2);
        l.put(1,1);
        l.put(2,2);
        l.get(1);
        l.put(3,3);
        l.get(2);
        l.put(4,4);
        l.get(1);
        l.get(3);
        l.get(4);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

