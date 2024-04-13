package leet.week12prep.Tree.DFS;

import leet.week12prep.Tree.BFS.TreeNode;

public class SameTree100 {
    public static void main(String[] args) {
        String[] array = new String[]{"3","9","20","14","18","15","7","23","30","34","35","32","45"};
        TreeNode Tree1 = TreeNode.createTree(array);
        String[] array2 = new String[]{"3","9","20","14","18","15","7","23","30","34","35","32","46"};
        TreeNode Tree2 = TreeNode.createTree(array2);
        System.out.println(isSameTree(Tree1,Tree2));
    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        else {
            if (p != null && q != null && p.val == q.val)
                return true && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
            else
                return false;
        }
    }
}
