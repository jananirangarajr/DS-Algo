package leet.week12prep.Tree.DFS;

import leet.week12prep.Tree.BFS.TreeNode;

public class MergeTwoBinaryTrees617 {
    public static void main(String[] args) {
        String[] array = new String[]{"3","9","20","14","18","15","7","23","30","34","35","32","45"};
        TreeNode Tree1 = TreeNode.createTree(array);
        String[] array2 = new String[]{"3","9","20","14","18","15"};
        TreeNode Tree2 = TreeNode.createTree(array2);
        TreeNode.printPreOrderTree(mergeTrees(Tree1,Tree2));
    }

    public static TreeNode mergeTrees(TreeNode tree1, TreeNode tree2) {
        if (tree2 == null && tree1 == null)
            return null;
        else if (tree2 == null)
            return tree1;
        else if (tree1 == null)
            return tree2;
        else {
            tree1.val = tree2.val + tree1.val;
            tree1.left = mergeTrees(tree1.left, tree2.left);
            tree1.right = mergeTrees(tree1.right, tree2.right);
            return tree1;
        }
    }

}
