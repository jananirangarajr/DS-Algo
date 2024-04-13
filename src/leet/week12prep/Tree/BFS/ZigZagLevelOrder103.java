package leet.week12prep.Tree.BFS;

import leet.week12prep.stack.FreqStack895;

import java.util.*;

public class ZigZagLevelOrder103 {
    public static void main(String[] args) {
        String[] array = new String[]{"3","9","20","14","18","15","7","23","30","34","35","32","45"};
        TreeNode root = TreeNode.createTree(array);
        List<List<Integer>> result = zigzagLevelOrder(root);
        System.out.println(result);
    }
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayDeque<Integer> levelList = new ArrayDeque<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while(!queue.isEmpty()){
            int level = queue.size();
            for (int i = 0; i < level; i++){
                TreeNode node = queue.poll();
                if (depth%2 == 0)
                    levelList.addLast(node.val);
                else
                    levelList.addFirst(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            depth++;
            result.add(new ArrayList<>(levelList));
            levelList.clear();
        }
        return result;
    }
}
