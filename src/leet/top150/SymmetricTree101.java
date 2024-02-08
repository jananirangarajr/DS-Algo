package leet.top150;

public class SymmetricTree101 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(2);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.right.left = new TreeNode(4);
        node.right.right = new TreeNode(3);
        System.out.println(isSymmetric(node));
    }
    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root.left,root.right);
    }

    private static boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        else if ((left == null && right !=null) || (left != null && right ==null))
            return false;
        else{
            if (left.val == right.val)
                return true && isMirror(left.left,right.right);
        }
        return false;
    }
}
