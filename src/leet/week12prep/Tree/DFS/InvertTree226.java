package leet.week12prep.Tree.DFS;

import leet.week12prep.Tree.BFS.TreeNode;

public class InvertTree226 {
    public static void main(String[] args) {
        String[] array = new String[]{"3","9","20","14","18","15","7","23","30","34","35","32","45"};
        TreeNode Tree1 = TreeNode.createTree(array);
        TreeNode result = invertTree(Tree1);
        TreeNode.printInOrderTree(result);
    }
    public static TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        else{
            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);
            root.left = right;
            root.right = left;
            return root;
        }
    }
}
