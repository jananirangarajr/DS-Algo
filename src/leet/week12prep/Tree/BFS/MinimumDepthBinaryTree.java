package leet.week12prep.Tree.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthBinaryTree {
    public static void main(String[] args) {
        String[] nodes = new String[] {"3","9","20","15","7","25","30","35","40"};
        TreeNode root = TreeNode.createTree(nodes);
        System.out.println(minDepth(root));
    }
    public static int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 1;
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                if (current.left == null && current.right == null)
                    return depth;
                if (current.left != null)
                    queue.add(current.left);
                if (current.right != null)
                    queue.add(current.right);
            }
            depth++;
        }
        return depth;
    }
}
