package leet.week12prep.Tree.DFS;

import leet.week12prep.Tree.BFS.TreeNode;

public class BinaryTreeMaximumSumPath124 {

    static int globalMax = Integer.MIN_VALUE;
    public static void main(String[] args) {
        String[] nodes = new String[] {"-30","9","20"};
        TreeNode root = TreeNode.createTree(nodes);
        System.out.println(maxPathSum(root));
    }
    public static int maxPathSum(TreeNode root) {
        //maximum among all the path
        int max = maxPath(root);
        System.out.println(max);
        return globalMax;
    }

    private static int maxPath(TreeNode root) {
        if (root == null)
            return 0;
//        else if (root.right == null && root.left == null)
//            return root.val;
        else{
            int leftSum = maxPath(root.left);
            int rightSum = maxPath(root.right);
            //same as below commented lines, just assigning variables to it
            int maxRightLeft = Math.max(leftSum,rightSum);
            int withRoot = Math.max(root.val, (maxRightLeft+root.val));
            int allMax = Math.max(withRoot, leftSum+rightSum+root.val);
            globalMax = Math.max(globalMax,allMax);
            return withRoot;
//            globalMax = Math.max(globalMax,Math.max(root.val, Math.max(leftSum+rightSum+ root.val,
//                    Math.max(Math.max(leftSum,rightSum),
//                            Math.max(leftSum+ root.val,rightSum+root.val)))));
//            return Math.max(root.val, Math.max(leftSum+rightSum+root.val,Math.max(leftSum+ root.val,rightSum+root.val)));
        }
    }
}
