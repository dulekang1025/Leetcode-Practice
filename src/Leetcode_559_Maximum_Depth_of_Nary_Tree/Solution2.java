package Leetcode_559_Maximum_Depth_of_Nary_Tree;


public class Solution2 {
    public int maxDepth(Node root) {
        int max = 0;
        if(root == null) return max;
        for(Node c : root.children){
            int i = maxDepth(c);
            if(max < i) max = i;
        }
        return max + 1;
    }
}
