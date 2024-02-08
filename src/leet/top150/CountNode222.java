package leet.top150;

public class CountNode222 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(1);
        node.right = new TreeNode(4);
        System.out.println(countNodes(node));
    }
    public static int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        else
            return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
