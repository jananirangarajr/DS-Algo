package leet.week12prep.Tree.DFS;

import leet.week12prep.Tree.BFS.TreeNode;

public class PathSum112 {
    public static void main(String[] args) {
        String[] array = new String[]{"3","9","20","14","18","15","7","23","30","34","35","32","45"};
        TreeNode Tree1 = TreeNode.createTree(array);
        int targetSum = 149;
        System.out.println(hasPathSum(Tree1,targetSum));
    }
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        if (targetSum - root.val == 0 && root.left == null && root.right == null)
            return true;

        return hasPathSum(root.left,targetSum-root.val) || hasPathSum(root.right,targetSum-root.val);
    }
}
