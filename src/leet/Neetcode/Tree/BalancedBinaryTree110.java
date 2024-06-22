package leet.Neetcode.Tree;

import leet.week12prep.Tree.BFS.TreeNode;

public class BalancedBinaryTree110 {
    static boolean result = true;
    public static void main(String[] args) {
        String[] array = new String[]{"1","2","2","3","null","null","3","4","null","null","4"};
        TreeNode Tree1 = TreeNode.createTree(array);
        System.out.println(isBalanced(Tree1));
    }

    public static boolean isBalanced(TreeNode root) {
        height(root);
        return result;
    }

    private static int height(TreeNode root){
        if (root == null)
            return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        result = result && Math.abs(leftHeight-rightHeight) > 1 ? false: true;
        System.out.println(result+" "+root.val);
        return 1+Math.max(leftHeight, rightHeight);
    }
}
