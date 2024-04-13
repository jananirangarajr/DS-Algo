package leet.week12prep.Tree.DFS;

import leet.week12prep.Tree.BFS.TreeNode;

public class DiameterOfBinaryTree543 {
    static int maximum = 0;
    public static void main(String[] args) {
        String[] nodes = new String[] {"3","9","20","null","null","15","7"};
        TreeNode root = TreeNode.createTree(nodes);
        diameterOfBinaryTree(root);
        System.out.println(maximum);
    }
    public static int diameterOfBinaryTree(TreeNode root) {
        //max height of right tree + max height of right tree for each node ==> result is Maximum among those value
        if (root  == null)
            return 0;
        else {
            int left = diameterOfBinaryTree(root.left); //height of left tree
            int right = diameterOfBinaryTree(root.right);//height of right Tree
            maximum = Math.max(maximum, left+right);// calculates the maximum height at every node
            return  1+Math.max(left,right); // returns height of the node
        }
    }
}
