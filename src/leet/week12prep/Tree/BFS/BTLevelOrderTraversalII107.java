package leet.week12prep.Tree.BFS;

import java.util.*;

public class BTLevelOrderTraversalII107 {
    public static void main(String[] args) {
        String[] nodes = new String[] {"3","9","20","null","null","15","7"};
        TreeNode root = TreeNode.createTree(nodes);
        List<List<Integer>> list = levelOrderBottom(root);
        System.out.println(list);
    }
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int level = queue.size();
            for (int i = 0; i < level; i++) {
                TreeNode currentNode = queue.poll();
                list.add(currentNode.val);
                if (currentNode.left != null)
                    queue.add(currentNode.left);
                if (currentNode.right != null)
                    queue.add(currentNode.right);
            }
            result.add(0,new ArrayList<>(list));
            list.clear();
        }
        return result;
    }
}
