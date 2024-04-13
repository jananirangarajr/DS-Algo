package leet.week12prep.Tree.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {

    public TreeNode left;
    public TreeNode right;
    public int val;

    public TreeNode(){}
    public TreeNode(int val){
        this.val = val;
        this.right = null;
        this.left = null;
    }
    public TreeNode(int val, TreeNode right, TreeNode left) {
        this.val = val;
        this.right = right;
        this.left = left;
    }

    public static TreeNode createTree(String[] array){
        if (array == null || array.length == 0)
            return null;
        TreeNode root = new TreeNode(Integer.valueOf(array[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
       while(i < array.length) {
           TreeNode currentNode = queue.remove();
           if (currentNode != null) {
               if (i < array.length) {
                   String val = array[i++];
                   if (val.equals("null") || val.equals("")) {
                       currentNode.left = null;
                   } else {
                       currentNode.left = new TreeNode(Integer.valueOf(val));
                   }
                   queue.add(currentNode.left);

               }
               if (i < array.length) {
                   String val = array[i++];
                   if (val.equals("null") || val.equals("")) {
                       currentNode.right = null;
                   } else {
                       currentNode.right = new TreeNode(Integer.valueOf(val));
                   }
                   queue.add(currentNode.right);
               }
           }
           else{
               i = i+2;
           }
       }
       return root;
    }
    public static void printInOrderTree(TreeNode root) {
        if (root  == null) {
            return;
        }
        printInOrderTree(root.left);
        System.out.println(root.val);
        printInOrderTree(root.right);
    }
    public static void printPreOrderTree(TreeNode root) {
        if (root  == null) {
            return;
        }
        System.out.println(root.val);
        printPreOrderTree(root.left);
        printPreOrderTree(root.right);
    }
    public static void printPostOrderTree(TreeNode root) {
        if (root  == null) {
            return;
        }
        printPostOrderTree(root.left);
        printPostOrderTree(root.right);
        System.out.println(root.val);
    }


}
