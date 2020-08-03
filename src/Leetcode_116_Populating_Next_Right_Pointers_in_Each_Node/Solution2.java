package Leetcode_116_Populating_Next_Right_Pointers_in_Each_Node;

import java.util.LinkedList;
import java.util.Queue;

class Solution2{
    public Node connect(Node root) {
        if(root == null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            Node pre = null;
            for(int i = 0; i < size; i++){
                Node cur = queue.poll();
                if(pre == null) pre = cur;
                else{
                    pre.next = cur;
                    pre = cur;
                }
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }
        }
        return root;
    }
}
