package leet.week12prep.Tree.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSide199 {
    public static void main(String[] args) {
        String[] nodes = new String[] {"3","9","20","null","null","15","7"};
        TreeNode root = TreeNode.createTree(nodes);
        System.out.println(rightSideView(root));
    }
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int levelsize = queue.size();
            for (int i = 0; i < levelsize; i++){
                TreeNode current = queue.poll();
                if (i == levelsize-1)
                    list.add(current.val);
                if (current.left!= null)
                    queue.add(current.left);
                if (current.right != null)
                    queue.add(current.right);
            }
        }
        return list;
    }

}
