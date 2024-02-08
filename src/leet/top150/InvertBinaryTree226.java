package leet.top150;

public class InvertBinaryTree226 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode();
        node.val = 2;
        node.left = new TreeNode(1);
        node.right = new TreeNode(3);
        invertTree(node);
        node.printTree(node);
    }
    public static TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;
        else {
            TreeNode right = invertTree(root.right);
            TreeNode left = invertTree(root.left);
            root.left = right;
            root.right = left;
            return root;
        }

    }
}
