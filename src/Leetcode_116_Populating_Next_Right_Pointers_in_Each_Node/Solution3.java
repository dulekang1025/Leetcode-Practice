package Leetcode_116_Populating_Next_Right_Pointers_in_Each_Node;

public class Solution3 {
    public Node connect(Node root) {
        if(root == null || root.left ==null) return root;
        root.left.next = root.right;
        if(root.next != null) root.right.next = root.next.left;
        connect(root.left);
        connect(root.right);
        return root;
    }
}
