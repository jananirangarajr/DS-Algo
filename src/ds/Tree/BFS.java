package ds.Tree;

import leet.week12prep.Tree.BFS.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        String[] array = new String[]{"3","9","20","14","18","15","7","23","30","34","35","32","45"};
        TreeNode tree = TreeNode.createTree(array);

        //BFS Logic
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        q.add(tree);
        while(!q.isEmpty()) {
            int level = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < level; i++){
                TreeNode currentNode = q.poll();
                list.add(currentNode.val);
                if (currentNode.left != null)
                    q.offer(currentNode.left);
                if (currentNode.right != null)
                    q.offer(currentNode.right);
            }
            result.add(list);
        }
        System.out.println(result);
    }
}
