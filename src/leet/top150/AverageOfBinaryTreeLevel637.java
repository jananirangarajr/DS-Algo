package leet.top150;

import java.util.*;

public class AverageOfBinaryTreeLevel637 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(2);
        node.right = new TreeNode(-3);
        System.out.println(averageOfLevels(node));
    }
    public static List<Double> averageOfLevels(TreeNode root) {
        /*if (root ==  null)
            return new ArrayList<Double>();
        else {
            Queue<TreeNode> queue = new LinkedList<>();
            List<Double> average = new ArrayList<>();
            queue.add(root);
            while(!queue.isEmpty()){
                Double levelSum = (double) 0;
                int noOfNodes = queue.size();
                for (int i = 0; i < noOfNodes; i++) {
                    TreeNode node = queue.remove();
                    levelSum += node.val;
                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null)
                        queue.add(node.right);
                }
                average.add(levelSum/noOfNodes);
            }
            return average;
        }*/

        List<double[]> list = new ArrayList<>();
        dfs(root,0,list);
        List<Double> average = new ArrayList<>();
        for (double[] d : list){
            average.add(d[0]/d[1]);
        }
        return average;
    }

    private static void dfs(TreeNode root, int level, List<double[]> list) {
        if (root == null)
            return;
        if (list.size() == level) list.add(new double[2]);
        list.get(level)[0] += root.val;
        list.get(level)[1] +=1;
        dfs(root.left,level+1,list);
        dfs(root.right,level+1,list);

    }
}
