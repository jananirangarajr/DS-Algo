package leet.week12prep.Tree.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTLevelOrderTraversal102 {

    public static void main(String[] args) {
        String[] nodes = new String[] {"3","9","20","null","null","15","7"};
        TreeNode root = TreeNode.createTree(nodes);
        List<List<Integer>> list = levelOrder(root);
        System.out.println(list);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> levelList = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()){
            level = queue.size();
            for (int i = 0 ; i < level; i++) {
                TreeNode current = queue.remove();
                if (current != null){
                    levelList.add(current.val);
                    if (current.left != null)
                        queue.add(current.left);
                    if (current.right != null)
                        queue.add(current.right);
                }
            }
            if (levelList.size() > 0)
                result.add(new ArrayList<>(levelList));
            levelList.clear();
        }
        return result;
    }
}
