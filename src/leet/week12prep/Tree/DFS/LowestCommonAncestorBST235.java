package leet.week12prep.Tree.DFS;

import leet.week12prep.Tree.BFS.TreeNode;

public class LowestCommonAncestorBST235 {
    public static void main(String[] args) {
        String[] nodes = new String[] {"3","9","20","null","null","15","7"};
        TreeNode root = TreeNode.createTree(nodes);
        TreeNode result = lowestCommonAncestor(root,root.right,root.left);
        System.out.println(result.val);
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // if (root == null || root == p || root == q)
        //     return root;
        // else {
        //     TreeNode left = lowestCommonAncestor(root.left,p,q);
        //     TreeNode right = lowestCommonAncestor(root.right,p,q);
        //     if (left != null && right != null)
        //         return root;
        //     return left != null?left:right;
        // }

        //possibilities : since BST, p & q < root / p & q > root / p/q <= root <= p/q
        int small = Math.min(p.val, q.val);
        int large = Math.max(p.val,q.val);
        while(root != null){

            if (root.val > large) // p & q in left tree
                root = root.left;
            else if (root.val < small) // p & q in right tree
                root = root.right;
            else //p & q in both left and right
                return root;
        }
        return null;
    }
}
