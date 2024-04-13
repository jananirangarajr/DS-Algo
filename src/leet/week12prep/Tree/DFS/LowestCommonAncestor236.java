package leet.week12prep.Tree.DFS;

import leet.week12prep.Tree.BFS.TreeNode;

public class LowestCommonAncestor236 {
    public static void main(String[] args) {
        String[] nodes = new String[] {"3","9","20","null","null","15","7"};
        TreeNode root = TreeNode.createTree(nodes);
        TreeNode result = lowestCommonAncestor(root,root.left,root.right);
        System.out.println(result.val);
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // for a node, find P and Q are it's child. if yes return that first found node
        if (root == null || root == p || root == q)
            return root;
        else {
            TreeNode left = lowestCommonAncestor(root.left, p,q);
            TreeNode right =lowestCommonAncestor(root.right,p,q);
            if (left != null && right != null)
                return root;
            if (left != null)
                return left;
            else
                return right;
        }
    }
}
