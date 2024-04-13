package leet.week12prep.Tree.DFS;

import leet.week12prep.Tree.BFS.TreeNode;

public class ValidateBST98 {
    public static void main(String[] args) {
        String[] nodes = new String[] {"30","9","32","null","null","31","25"};
        TreeNode root = TreeNode.createTree(nodes);
        System.out.println(isValidBST(root));
    }
    public static boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        else {
            if (root.left == null && root.right == null)
                return true;
            boolean leftValid = isValidBST(root.left);
            boolean rightValid = isValidBST(root.right);
            if (leftValid && rightValid) {
                if (root.left != null && root.left.val > root.val)
                    leftValid = false;
                if (root.right != null && root.right.val < root.val)
                    rightValid = false;
            }
            return leftValid && rightValid;
        }
    }
}
