package leet.week12prep.Tree.DFS;

import leet.week12prep.Tree.BFS.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII113 {
    public static void main(String[] args) {
        String[] array = new String[]{"3","9","20","14","18","15","7"};
        TreeNode Tree1 = TreeNode.createTree(array);
        List<List<Integer>> result = pathSum(Tree1,26);
        System.out.println(result);

    }
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        pathSum(root,targetSum,result,new ArrayList<>());
        return result;
    }

    private static <E> void pathSum(TreeNode root, int targetSum, List<List<Integer>> result, ArrayList<Integer> list) {
//         if (targetSum == 0)
//            result.add(new ArrayList<>(list));
//        else if (root == null || targetSum < 0)
//            return;
//        else {
//            list.add(root.val);
//            pathSum(root.left,targetSum-root.val,result,list);
//            list.remove(list.size()-1);
//            pathSum(root.right,targetSum,result,list);
//         }
        if (root == null)
            return;
        list.add(root.val);
        if (targetSum == root.val && root.left == null && root.right == null) {
            result.add(new ArrayList(list));
            list.remove(list.size()-1);
            return;
        }
        else {
            pathSum(root.left, targetSum-root.val, result,list);
            pathSum(root.right,targetSum-root.val, result, list);
        }
        list.remove(list.size()-1);
    }
}
