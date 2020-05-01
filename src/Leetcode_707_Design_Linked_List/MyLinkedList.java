package Leetcode_707_Design_Linked_List;

class MyLinkedList {

    public int length;
    public Node head;
    public Node tail;

    class Node{
        public int val;
        public Node next;
        public Node(int val){
            this.val = val;
        }
    }

    /** Initialize your data structure here. */
    public MyLinkedList() {
        length = 0;
        head = null;
        tail = null;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index >= length) return -1;
        Node cur = head;
        for(int i = 0; i < index; i++){
            cur = cur.next;
        }
        return cur.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node = new Node(val);
        if(head == null){
            head = node;
            tail = head;
        }else{
            node.next = head;
            head = node;
        }
        length++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node node = new Node(val);
        if(tail == null){
            tail = node;
            head = node;
        }else{
            tail.next = node;
            tail = node;
        }
        length++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > length) return;
        else if(index == 0) addAtHead(val);
        else if(index == length) addAtTail(val);
        else{
            Node node = new Node(val);
            Node cur = head;
            for(int i = 0; i < index - 1; i++){
                cur = cur.next;
            }
            Node t = cur.next;
            cur.next = node;
            node.next = t;
            length++;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index >= length) return;
        else if(index == 0){
            Node t = head;
            head = head.next;
            t.next = null;
        }else if(index == length - 1){
            Node cur = head;
            while(cur.next != tail){
                cur = cur.next;
            }
            tail = cur;
            tail.next = null;
        }else{
            Node cur = head;
            for(int i = 0; i < index - 1; i++){
                cur = cur.next;
            }
            Node t = cur.next;
            cur.next = t.next;
            t.next = null;
        }
        length--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
