package leet.top150;

// Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public void printTree(TreeNode root) {
        if (root != null){
            printTree(root.left);
            System.out.println(root.val);
            printTree(root.right);
        }
    }
}
