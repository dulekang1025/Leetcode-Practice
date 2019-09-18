package Leetcode_105_Bulid_Tree_from_Pre_Inorder;
import TreeNode.TreeNode;

//对于给定的前序遍历preorder和中序遍历inorder，
//首先我们不难发现，这棵树的根结点其实就是preorder[0]。
//由于preorder和inorder是对同一棵树的遍历，
//我们可以知道preorder[0]在inorder中一定也存在，不妨设preorder[0]==inorder[k]。
//由于inorder是中序遍历，所以k左边的就是根节点左子树的中序遍历、k右边的就是根节点右子树的中序遍历。
//并且，由于我们已经知道了根节点左子树的节点数（与中序遍历长度相同），
//不妨设为l，我们可以知道preorder从1到l+1就是根节点左子树的前序遍历，
//剩下的最后一部分就是根节点右子树的前序遍历。

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,inorder,0,0,inorder.length - 1);
    }

    // preStart: search for new root node; inStrat, inEnd: search for subtree
    public TreeNode helper(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd){
        if(preStart > preorder.length - 1  || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int v = preorder[preStart];
        int k = 0;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i] == v){
                k = i;
                break;
            }
        }

        root.left = helper(preorder,inorder,preStart + 1,inStart, k - 1);
        root.right = helper(preorder,inorder, preStart + (k - inStart) + 1,k + 1, inEnd);
        return root;
    }
}
