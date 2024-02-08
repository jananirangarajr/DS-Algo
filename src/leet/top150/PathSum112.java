package leet.top150;


public class PathSum112 {
    public static void main(String[] args) {
        int targetSum = 0;
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(2);
        System.out.println(hasPathSum(node,targetSum));

    }
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        if(root.left == null && root.right == null && targetSum - root.val == 0)
            return true;
        else {
            return hasPathSum(root.left,targetSum-root.val) || hasPathSum(root.right, targetSum - root.val);
        }

    }
}
