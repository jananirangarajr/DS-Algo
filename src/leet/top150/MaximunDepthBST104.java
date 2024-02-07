package leet.top150;

public class MaximunDepthBST104 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode();
        node.val = 3;
        System.out.println(maxDepth(node));

    }
    public static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        int left =  maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right)+1;
    }
}


