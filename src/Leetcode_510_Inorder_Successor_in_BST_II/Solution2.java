package Leetcode_510_Inorder_Successor_in_BST_II;

public class Solution2 {
    public Node inorderSuccessor(Node node) {
        if(node == null) return node;
        if(node.right != null){
            Node temp = node;
            temp = temp.right;
            while(temp.left != null){
                temp = temp.left;
            }
            return temp;
        }
        while(node.parent != null && node != node.parent.left){
            node = node.parent;
        }
        return node.parent;
    }
}
