package leet.top150;

import java.util.ArrayList;

public class MinABSOfBST530 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        System.out.println(getMinimumDifference(root));
    }
    public static int getMinimumDifference(TreeNode root) {
        return ABSOfBST(new ArrayList<>(),Integer.MAX_VALUE,root);
    }

    private static int ABSOfBST(ArrayList<Integer> list, int diff, TreeNode root) {
        if (root == null)
            return diff;
        else {
            for (Integer i : list) {
                diff = Math.min(diff, Math.abs(i - root.val));
            }
            list.add(root.val);
            diff = ABSOfBST(list,diff,root.left);
            diff = ABSOfBST(list,diff,root.right);
            list.remove(list.size()-1);
            return diff;
        }
    }
}
