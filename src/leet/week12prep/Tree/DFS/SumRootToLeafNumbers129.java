package leet.week12prep.Tree.DFS;

import leet.week12prep.Tree.BFS.TreeNode;

public class SumRootToLeafNumbers129 {
    public static void main(String[] args) {
        String[] nodes = new String[] {"4","9","0","5","1"};
        TreeNode root = TreeNode.createTree(nodes);
        System.out.println(sumNumbers(root));
    }
    public static int sumNumbers(TreeNode root) {
       int result = sumNumbersResult(root,0);
       return result;
    }

    private static int sumNumbersResult(TreeNode root,int sum ) {
        if (root == null)
            return 0;
        if (root.right == null && root.left == null)
            return root.val+(sum*10);
        else
            return sumNumbersResult(root.left, sum*10+ root.val) + sumNumbersResult(root.right,sum*10+root.val);
    }

    public static String sumNumbersString(TreeNode root){
        if (root == null)
            return "";
        else {
            if (root.left == null && root.right == null)
                return String.valueOf(root.val);

//            String leftValue =  sumNumbersString(root.left);
//            System.out.println(leftValue);
//            String rightValue = sumNumbersString(root.right);
//            System.out.println(rightValue);
//            if (leftValue != ""){
//                if (leftValue.length() <= 1)
//                    leftValue = root.val+leftValue;
//                else {
//                    int temp = root.val+Integer.valueOf(leftValue.charAt(0));
//                    leftValue = String.valueOf(temp)+leftValue.substring(1);
//                }
//            }
//            if (rightValue != ""){
//                if (rightValue.length() <= 1)
//                    rightValue = root.val+rightValue;
//                else {
//                    int temp = root.val+Integer.valueOf(rightValue.charAt(0));
//                    rightValue = String.valueOf(temp)+rightValue.substring(1);
//                }
//            }
//            System.out.println(leftValue);
//            System.out.println(rightValue);
//            if (leftValue != "" && rightValue != "") {
//                return String.valueOf(Integer.valueOf(leftValue) + Integer.valueOf(rightValue));
//            }
//            return leftValue != ""?leftValue:rightValue;
        }
        return "";
    }
}
