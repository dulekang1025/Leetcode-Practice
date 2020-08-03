package Leetcode_117_Populatin_Next_Right_Pointers_in_Each_Node_II;

public class Solution3 {
    public Node connect(Node root) {
        if(root == null || (root.left == null && root.right == null)) return root;
        if(root.left != null && root.right != null){
            root.left.next = root.right;
            root.right.next = find(root.next);
        }
        else if(root.right != null){
            root.right.next = find(root.next);
        }
        else if(root.left != null){
            root.left.next = find(root.next);
        }
        connect(root.right);
        connect(root.left);
        return root;
    }
    private Node find(Node cur){
        Node next = null;
        while(cur != null){
            if(cur.left != null){
                next = cur.left;
                break;
            }
            if(cur.right != null){
                next = cur.right;
                break;
            }
            cur = cur.next;
        }
        return next;
    }
}
