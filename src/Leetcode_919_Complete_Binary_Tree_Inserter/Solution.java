package Leetcode_919_Complete_Binary_Tree_Inserter;

import TreeNode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class CBTInserter {

    TreeNode root;
    Queue<TreeNode> queue;

    public CBTInserter(TreeNode root) {
        this.root = root;
        queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.peek();
            if(cur.left != null) queue.add(cur.left);
            else break;
            if(cur.right != null) queue.add(cur.right);
            else break;
            queue.poll();
        }
    }

    public int insert(int v) {
        TreeNode cur = queue.peek();
        TreeNode node = new TreeNode(v);
        if(cur.left == null){
            cur.left = node;
            queue.add(node);
        }else if(cur.right == null){
            cur.right = node;
            queue.poll();
            queue.add(node);
        }
        return cur.val;
    }

    public TreeNode get_root() {
        return this.root;
    }
}

