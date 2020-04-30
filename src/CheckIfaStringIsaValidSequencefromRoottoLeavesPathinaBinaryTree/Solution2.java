package CheckIfaStringIsaValidSequencefromRoottoLeavesPathinaBinaryTree;

import TreeNode.TreeNode;

class Solution2 {
    public boolean isValidSequence(TreeNode root, int[] arr) {
        return helper(root, arr, 0);
    }
    public boolean helper(TreeNode root, int[] arr, int i){
        if(root == null) return i == arr.length;
        if(root.val != arr[i]) return false;
        if(i == arr.length - 1)
            return root.left == null && root.right == null;
        boolean left = helper(root.left, arr, i + 1);
        boolean right = helper(root.right, arr, i + 1);
        return left || right;
    }
}
