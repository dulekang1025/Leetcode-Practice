package Create_BST;


//一个二叉树如果想成为二叉查找树需要满足以下条件：
//        （1）若任意节点的左子树不空，则左子树上所有结点的值均小于或等于它的根结点的值；
//        （2）若任意节点的右子树不为空，则右子树上所有节点的值均大于或等于根节点的值；
//        （3）任意节点的左、右子树也分别为二叉查找树。
//

public class BST {
    int val;
    public BST left;
    public BST right;

    public BST(int x) {
        val = x;
    }

    public void addNode(int num) {
        if (num < this.val) {
            if (this.left != null) {
                this.left.addNode(num);
            } else {
                this.left = new BST(num);
            }
        }else {        // if equal, add at right side
            if (this.right != null) {
                this.right.addNode(num);
            } else {
                this.right = new BST(num);
            }
        }


    }
    // Visit the node first, then left and right sub-trees
    public void traversePreOrder() {
        System.out.println(this.val);
        if (this.left != null) {
            this.left.traversePreOrder();
        }
        if (this.right != null) {
            this.right.traversePreOrder();
        }
    }

    // Visit left sub-tree, then node and then, right sub-tree
    public void traverseInOrder() {
        if (this.left != null) {
            this.left.traverseInOrder();
        }
        System.out.println(this.val);
        if (this.right != null) {
            this.right.traverseInOrder();
        }
    }

    // Visit left sub-tree, then right sub-tree and then the node
    public void traversePostOrder() {
        if (this.left != null) {
            this.left.traversePostOrder();
        }
        if (this.right != null) {
            this.right.traversePostOrder();
        }
        System.out.println(this.val);
    }
}
